import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Node{
        int st;
        int ed;
        int w;
        Node(int st, int ed, int w){
            this.st = st;
            this.ed = ed;
            this.w = w;
        }
    }
    static int[] dist;
    static int[] indegree;
    static List<Node>[] list;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        indegree = new int[N+1];
        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dist, INF);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list[A].add(new Node(A, B, C));
            list[B].add(new Node(B, A, C));
        }

        dijkstra(1);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i=2; i<=N; i++){
            if(dist[i] != INF && dist[i] !=0){
                sb.append(i).append(" ").append(indegree[i]).append("\n");
                cnt++;
            }
        }
        System.out.println(cnt);
        System.out.println(sb);

    }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> o1.w - o2.w);

        dist[start] = 0;
        pq.offer(new Node(0, 1, 0));

        while(!pq.isEmpty()){
            Node temp = pq.poll();

            if(temp.w != dist[temp.ed]){
                continue;
            }

            indegree[temp.ed] = temp.st;

            for(int i=0; i<list[temp.ed].size(); i++){
                Node next = list[temp.ed].get(i);

                int dis = temp.w + next.w;
                if(dis< dist[next.ed]){
                    dist[next.ed] = dis;
                    pq.offer(new Node(temp.ed, next.ed, dis));
                }
            }
        }
    }
}