import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int last;
        int cur;
        int cnt;

        Node(int last, int cur, int cnt){
            this.last = last;
            this.cur = cur;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[100_010];
        int[] last = new int[100_010];

        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(last, -1);

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, N, 0));
        last[N] = N;
        dp[N] = 0;

        while (!q.isEmpty()){
            Node temp = q.poll();
            if(temp.cnt != dp[temp.cur]){
                continue;
            }

            if(temp.cur == K){
                break;
            }

            int next = temp.cur-1;

            if(next >=0 && next <=100_000){
                if(temp.cnt+1 < dp[next]){
                    dp[next] = temp.cnt+1;
                    last[next] = temp.cur;
                    q.offer(new Node(temp.cur, next, temp.cnt+1));
                }
            }

            next = temp.cur+1;
            if(next >=0 && next <=100_000){
                if(temp.cnt+1 < dp[next]){
                    dp[next] = temp.cnt+1;
                    last[next] = temp.cur;
                    q.offer(new Node(temp.cur, next, temp.cnt+1));
                }
            }

            next = temp.cur * 2;
            if(next >=0 && next <=100_000){
                if(temp.cnt+1 < dp[next]){
                    dp[next] = temp.cnt+1;
                    last[next] = temp.cur;
                    q.offer(new Node(temp.cur, next, temp.cnt+1));
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        int idx = K;
        list.add(K);

        while (idx != N){
            idx = last[idx];
            list.add(idx);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()-1).append("\n");

        for(int i=list.size()-1; i>=0; i--){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);

    }
}