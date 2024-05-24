import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());

        long[] arr = new long[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        int ans = -1;
        for(int i=1; i<=N; i++){
            K -= arr[i];
            if(K < 0){
                ans = i;
                break;
            }
        }
        if(ans == -1){
            for(int i=N; i>=1; i--){
                K -= arr[i];
                if(K < 0){
                    ans = i;
                    break;
                }
            }
        }
        System.out.println(ans);
    }


}