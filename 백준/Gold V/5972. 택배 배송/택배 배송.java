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
    static List<Node>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        init();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        dijkstar(1);

        System.out.println(dist[N]);

    }
    public static void init(){
        list = new ArrayList[N+1];
        dist = new int[N+1];

        for(int i=0; i<=N; i++){
            dist[i] = Integer.MAX_VALUE;
            list[i] = new ArrayList<>();
        }
    }

    public static void dijkstar(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dis - o2.dis);

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node temp = pq.poll();

            if(temp.dis != dist[temp.ed]){
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