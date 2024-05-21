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

        int[] arr = new int[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i] += arr[i-1];
        }

        int left = 1;
        int right = 1;

        int max = 0;
        while (left<=N && right<=N){
            int sum = arr[right] - arr[left-1];

            if(sum > M){
                if(left == right){
                    right++;
                    left++;
                }else{
                    left++;
                }
            }else{
                max = Math.max(sum, max);
                right++;
            }
        }
        System.out.println(max);

    }
}