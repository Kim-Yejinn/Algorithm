import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=0; tc<T; tc++){
            N = sc.nextInt();

            dp = new int[N+1][1<<4];

            for(int i=0; i<=N; i++){
                Arrays.fill(dp[i], -1);
            }
            System.out.println(dfs(0,0));
        }
    }
    public static int dfs(int idx, int state){
        if(idx == N && state == 0){
            return 1;
        }
        if(idx >= N){
            return 0;
        }
        if(dp[idx][state] != -1){
            return dp[idx][state];
        }

        if(state == 0){
            dp[idx][state] = dfs(idx+1, 0)
                    + dfs(idx+1, 3)
                    + dfs(idx+1, 9)
                    + dfs(idx+1, 12)
                    + dfs(idx+2, 0);
        }else if(state == 3){
            dp[idx][state] = dfs(idx+1, 0)
                    + dfs(idx+1, 12);
        }else if(state == 6){
            dp[idx][state] = dfs(idx+1, 9);
        }else if(state == 9){
            dp[idx][state] = dfs(idx+1, 0)
                    + dfs(idx+1, 6);
        }else if(state == 12){
            dp[idx][state] = dfs(idx+1, 0)
                    + dfs(idx+1, 3);
        }
        return dp[idx][state];
    }
}