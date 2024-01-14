import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][][] dp;
    static int div = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new int[N+1][10][1<<10];
        for(int i=0; i<=N; i++){
            for(int j=0; j<10; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans = 0;

        for(int i=1; i<=9; i++){
            dp[0][0][0] = -1;
            ans = (ans+dfs(0, 1<<i, i)) % div;
        }
        System.out.println(ans);
    }

    public static int dfs(int idx, int state, int cur){
        if(idx == N-1){
            if(state == (1<<10)-1){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[idx][cur][state] != -1){
            return dp[idx][cur][state];
        }

        dp[idx][cur][state] = 0;
        if(cur == 0){
            dp[idx][cur][state] = dfs(idx+1, state | (1<<(cur+1)), cur + 1) % div;

        }else if(cur == 9){
            dp[idx][cur][state] = dfs(idx + 1, state | (1 << (cur - 1)), cur - 1) % div;
        }else{
            dp[idx][cur][state] = dfs(idx+1, state | (1<<(cur+1)), cur + 1) % div;

            dp[idx][cur][state] = (dp[idx][cur][state] + dfs(idx + 1, state | (1 << (cur - 1)), cur - 1)) % div;
        }
        return dp[idx][cur][state];
    }
}