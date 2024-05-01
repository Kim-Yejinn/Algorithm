import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];
        StringTokenizer st;
        for(int r=1; r<=N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=1; c<=N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
                dp[r][c] = dp[r-1][c] + dp[r][c-1] - dp[r-1][c-1] + arr[r][c];
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int r=1; r<=N; r++){
            for(int c=1; c<=N; c++){
                int dis = Math.min(r, c);

                for(int i=0; i<dis; i++) {
                    int temp = dp[r][c] - dp[r][c-i-1] - dp[r-i - 1][c] + dp[r-i-1][c-i-1];
                    ans = Math.max(ans, temp);
                }
            }
        }
        System.out.println(ans);
    }
}