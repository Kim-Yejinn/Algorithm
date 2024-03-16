import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<3; tc++){
            int N = Integer.parseInt(br.readLine());
            int[] coin = new int[N];
            int[] cnt = new int[N];

            int sum = 0;

            StringTokenizer st;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                sum += a*b;

                coin[i] = a;
                cnt[i] = b;
            }

            if(sum%2 == 1){
                System.out.println(0);
                continue;
            }
            boolean[] dp = new boolean[sum+1];
            dp[0] = true;
            for(int r=0; r<N; r++){
                for(int i=sum; i>=0; i--){
                    if(dp[i]) {
                        for(int j=1; j<=cnt[r]; j++){
                            dp[i + j * coin[r]] = true;
                        }
                    }
                }
            }
            if(dp[sum/2]){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}