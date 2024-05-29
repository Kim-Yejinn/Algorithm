import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int l;
        int r;
        Node(int l, int r){
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Node o) {
            if(o.l == this.l){
                return this.r - o.r;
            }
            return this.l - o.l;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            pq.offer(new Node(l, r));
        }

        int loc = 0;
        int max = 0;
        int last = 0;

        while (!pq.isEmpty()){
            Node temp = pq.poll();

            if(loc >= temp.l || max >= temp.l){
                loc = Math.max(temp.r, loc);
            }else{
                int diff = loc - last;

                if(diff + loc >= temp.l){
                    max = diff + loc;
                    loc = temp.r;
                    last = temp.l;
                }else{
                    break;
                }
            }
        }

        System.out.println(loc);
    }
}