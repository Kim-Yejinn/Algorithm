import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        long num;
        int cnt;

        Node(long num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cnt == o.cnt){
                return Long.compare(o.num, this.num);
            }
            return this.cnt - o.cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(A, 0));

        int ans = -1;
        while (!pq.isEmpty()){
            Node temp = pq.poll();

            if(temp.num == B){
                ans = temp.cnt;
                break;
            }
            long t = temp.num * 10 + 1;
            if(t <= B){
                pq.offer(new Node(t, temp.cnt+1));
            }
            t = temp.num*2;
            if(t <= B){
                pq.offer(new Node(t, temp.cnt+1));
            }
        }
        if(ans == -1){
            System.out.println(-1);
        }else{
            System.out.println(ans+1);
        }
    }
}