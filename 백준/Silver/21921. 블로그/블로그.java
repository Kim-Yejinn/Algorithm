import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i] += arr[i-1];
        }
        int left = 1;
        int right = X;

        int max = 0;
        int cnt = 0;

        while (right <= N){
            int t = arr[right] - arr[left-1];
            if(max < t){
                max = t;
                cnt = 1;
            }else if(max == t){
                cnt++;
            }
            right++;
            left++;
        }
        if(max == 0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(cnt);
        }

    }
}