import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int ed;
        int dis;
        Node(int ed, int dis){
            this.ed = ed;
            this.dis = dis;
        }
    }
    static int N;
    static int M;

    static List<Node>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        dist = new int[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dij(start);

        System.out.println(dist[end]);
    }
    public static void dij(int start){
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dis - o2.dis);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node temp = pq.poll();

            if(dist[temp.ed] != temp.dis){
                continue;
            }

            for(int i=0; i<list[temp.ed].size(); i++){
                Node next = list[temp.ed].get(i);
                int dis = temp.dis + next.dis;
                if(dis < dist[next.ed]){
                    dist[next.ed] = dis;
                    pq.offer(new Node(next.ed, dis));
                }
            }
        }
    }
}