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
    static List<Node>[] list;
    static int[] dist;

    static int N;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i =0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());


        dijkstra(a);
        long AToB = dist[b];

        dijkstra(1);

        long oneToA = dist[a];
        long oneToB = dist[b];

        dijkstra(N);

        long NToA = dist[a];
        long NToB = dist[b];

        long min = Integer.MAX_VALUE;

        min = Math.min(min, (oneToA+AToB+NToB));
        min = Math.min(min, (oneToB+AToB+NToA));

        min = Math.min(min, (oneToA+AToB*2+NToA));
        min = Math.min(min, (oneToB+AToB*2+NToB));

        if(min >= Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }

    }

    public static void init(){
        dist = new int[N+1];
        for(int i=0; i<N+1; i++){
            dist[i] = INF;
        }
    }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> o1.weight-o2.weight);

        init();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node temp = pq.poll();

            if(temp.weight != dist[temp.ed]){
                // 방문 이미 했다면
                // 더 짧은 것으로 처리해버렸다면
                continue;
            }

            for(int i=0; i<list[temp.ed].size(); i++){
                Node next = list[temp.ed].get(i);
                int dis = temp.weight + next.weight;

                if(dis < dist[next.ed]){
                    dist[next.ed] = dis;
                    pq.offer(new Node(next.ed, dis));
                }
            }

        }
    }
}