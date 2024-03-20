import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int ed;
        long dis;
        Node(int ed, long dis){
            this.ed = ed;
            this.dis = dis;
        }
    }
    static int N;
    static int M;
    static List<Node>[] list;
    static long[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, i));
            list[b].add(new Node(a, i));
        }

        dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);

        dij(1);
        System.out.println(dist[N]);
    }

    public static void dij(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> Long.compare(o1.dis, o2.dis));
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node temp = pq.poll();

            if(temp.ed == N){
                continue;
            }

            if(temp.dis != dist[temp.ed]){
                continue;
            }

            for(int i=0; i<list[temp.ed].size(); i++){
                Node next = list[temp.ed].get(i);

                long lastTime = temp.dis % M;
                long nextTime = next.dis;
                long div = temp.dis/M;

                long newTime = div*M + nextTime;

                if(lastTime > nextTime){
                    newTime += M;
                }

                if(dist[next.ed] > newTime){
                    dist[next.ed] = newTime;
                    pq.offer(new Node(next.ed, newTime));
                }
            }
        }
    }
}