import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M];

        for(int r=1; r<=N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N+1][M];

        for(int c=0; c<M; c++){
            dp[1][c] = arr[1][c];
            if(c!=0){
                dp[1][c] += dp[1][c-1];
            }
        }


        for(int r=2; r<=N; r++){
            int[] tempL = new int[M];
            int[] tempR = new int[M];

            for(int c=0; c<M; c++){
                tempL[c] = tempR[c] = dp[r-1][c]+arr[r][c];
            }
            // L
            for(int c=1; c<M; c++){
                tempL[c] = Math.max(tempL[c], tempL[c-1] + arr[r][c]);
            }
            // R
            for(int c=M-2; c>=0; c--){
                tempR[c] = Math.max(tempR[c], tempR[c+1]+arr[r][c]);
            }
            for(int c=0; c<M; c++){
                dp[r][c] = Math.max(tempL[c], tempR[c]);
            }
        }

        System.out.println(dp[N][M-1]);
    }
}