import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int u;
        int v;
        Node(int u, int v){ // u-> v
            this.u = u;
            this.v = v;
        }
    }

    static List<Node>[] list;
    static boolean[] visit;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        visit = new boolean[N+1];
        dp = new int[N+1][2];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();;
        }

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(new Node(u, v));
            list[v].add(new Node(v, u));
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }
    public static void dfs(int num){
        visit[num] = true;
        dp[num][0] = 0;
        dp[num][1] = 1;

        for(int i=0; i<list[num].size(); i++){
            int next = list[num].get(i).v;
            if(!visit[next]){
                dfs(next);
                dp[num][0] += dp[next][1];
                dp[num][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}
