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

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        visit = new boolean[N+1];
        pq = new PriorityQueue<>((o1, o2)-> o1.weight-o2.weight);
        dis = 0;

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int r=1; r<=N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=1; c<=N; c++){
                if(r==c){
                    st.nextToken();
                }else{
                    list[r].add(new Node(r, c, Integer.parseInt(st.nextToken())));
                }
            }
        }
        primMST();
        System.out.println(dis);

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