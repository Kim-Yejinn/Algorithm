import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        boolean[][] dp = new boolean[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            dp[i][i] = true;
            int left = i-1;
            int right = i+1;

            // 홀수개
            while (left > 0 && right <=N){
                if(arr[left] == arr[right]){
                    dp[left][right] = true;
                    left--;
                    right++;
                }else{
                    break;
                }
            }

            // 짝수개
            left = i;
            right = i+1;
            while (left > 0 && right <=N){
                if(arr[left] == arr[right]){
                    dp[left][right] = true;
                    left--;
                    right++;
                }else{
                    break;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if(dp[S][E]){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}