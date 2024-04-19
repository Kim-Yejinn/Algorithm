import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] dp;

    static int N;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        size = 1;

        for(int i=1 ; i<N; i++){
            if(dp[size-1] < arr[i]){
                dp[size++] = arr[i];
            }else{
                int idx = lower_bound(arr[i]);
                dp[idx] = arr[i];
            }
        }
        System.out.println(size);
    }
    public static int lower_bound(int target){
        int left = 0;
        int right = size -1;

        while (left<right){
            int mid = (left+right)/2;

            if(dp[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return right;
    }
}