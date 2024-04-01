import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken()) -1;
        long B = Long.parseLong(st.nextToken());


        long[] dp = new long[65];
        dp[0] = 1;
        for(int i=1; i<60; i++){
            dp[i] = dp[i-1]*2 + (1L << (i));
        }

        long acnt = A & 1;
        long bcnt = B & 1;

        for(int i=60; i>0; i--){
            if((A & (1L <<i)) > 0){
                acnt += dp[i-1] + (A - (1L << i) + 1);
                A -= (1L << i);
            }
        }

        for(int i=60; i>0; i--){
            if((B & (1L <<i)) > 0){
                bcnt += dp[i-1] + (B - (1L << i) + 1);
                B -= (1L << i);
            }
        }
        System.out.println(bcnt - acnt);
    }
}