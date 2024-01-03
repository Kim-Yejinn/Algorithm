import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] dp = new long[N];
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
            dp[i] = Long.MAX_VALUE;
        }
        dp[0] = 0;

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                long cal = (j-i)*(1+Math.abs(arr[i]-arr[j]));

                if(dp[j]>Math.max(cal, dp[i])){
                    dp[j] = Math.max(cal, dp[i]);
                }
            }
        }
        System.out.println(dp[N-1]);
    }
}