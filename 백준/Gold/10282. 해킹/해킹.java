import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Node{
        int ed;
        int weight;

        Node(int ed, int weight){
            this.ed = ed;
            this.weight = weight;
        }
    }
    static int[] dist;
    static List<Node>[] list;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            dist = new int[N+1];
            list = new ArrayList[N+1];

            for(int i=1; i<=N; i++){
                list[i] = new ArrayList<>();
            }

            Arrays.fill(dist, INF);

            for(int i=0; i<D; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list[b].add(new Node(a, s));
            }

            dijkstra(C);

            int cnt = 0;
            int time = 0;

            for(int i=1; i<=N; i++){
                if(dist[i] != INF){
                    cnt++;
                    if(dist[i] > time){
                        time = dist[i];
                    }
                }
            }
            System.out.println(cnt+" "+time);
        }

    }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node temp = pq.poll();

            // 방문했으면 패스
            if(temp.weight != dist[temp.ed]){
                continue;
            }

            for(int i=0; i<list[temp.ed].size(); i++){
                Node next = list[temp.ed].get(i);

                int dis = next.weight + temp.weight;
                if(dis < dist[next.ed]){
                    dist[next.ed] = dis;
                    pq.offer(new Node(next.ed, dis));
                }
            }
        }
    }
}