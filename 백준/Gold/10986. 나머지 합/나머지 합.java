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

        st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());

            if(i>0){
                arr[i] += arr[i-1];
            }
        }
        long cnt = 0;

        long[] remainer = new long[M];

        for(int i=0; i<N; i++){
            int div = (int) (arr[i]%M);
            if(div==0){
                cnt++;
            }
            remainer[div]++;
        }

        for(int i=0; i<M; i++){
            if(remainer[i] > 1){
                cnt += (remainer[i] * (remainer[i]-1))/2;
            }
        }

        System.out.println(cnt);
    }
}