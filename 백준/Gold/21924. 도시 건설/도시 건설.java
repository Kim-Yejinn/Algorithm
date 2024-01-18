import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int st;
        int ed;
        int weight;
        Node(int st, int ed, int weight){
            this.st = st;
            this.ed = ed;
            this.weight = weight;
        }
    }
    static long dis;
    static List<Node>[] list;
    static boolean[] visit;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dis = 0;
        list = new ArrayList[N+1];
        visit = new boolean[N+1];
        pq = new PriorityQueue<>((o1, o2)-> o1.weight-o2.weight);

        long sum =0;
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            sum+=w;
            list[s].add(new Node(s,f,w));
            list[f].add(new Node(f,s,w));
        }
        primMST();

        boolean check = false;

        for(int i=1; i<=N; i++){
            if(!visit[i]){
                check = true;
                break;
            }
        }

        if(check){
            System.out.println(-1);
        }else{
            System.out.println(sum-dis);
        }

    }
    public static void primMST(){
        pq.offer(new Node(1,1,0));

        while (!pq.isEmpty()){
            Node temp = pq.poll();

            if(visit[temp.ed]){
                continue;
            }

            visit[temp.ed] = true;
            dis += temp.weight;

            for(int i=0; i<list[temp.ed].size();i++){
                Node next = list[temp.ed].get(i);

                if(!visit[next.ed]){
                    pq.offer(next);
                }
            }
        }
    }
}