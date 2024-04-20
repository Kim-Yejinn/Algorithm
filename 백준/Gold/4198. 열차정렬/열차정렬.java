import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] A;
    static int[] dp;
    static int[] reversedp;

    static int size;
    static int reverse_size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        dp = new int[N];
        reversedp = new int[N];

        int[] lis = new int[N];
        int[] lds = new int[N];

        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        for(int k=0; k<N; k++){
            dp[0] = A[k];
            reversedp[0] = -A[k];

            size = 1;
            reverse_size = 1;

            for(int i=k+1; i<N; i++){
                if(dp[size-1] < A[i]){
                    dp[size++] = A[i];
                }else{
                    if(dp[0] < A[i]){
                        int idx = search(A[i], size-1, dp);
                        dp[idx] = A[i];
                    }
                }

                if(reversedp[reverse_size-1] < -A[i]){
                    reversedp[reverse_size++] = -A[i];
                }else{
                    if(reversedp[0] < -A[i]){
                        int idx = search(-A[i], reverse_size-1, reversedp);
                        reversedp[idx] = -A[i];
                    }
                }
            }
            lis[k] = size;
            lds[k] = reverse_size;
        }

        int max = 0;
        for(int i=0; i<N; i++){
            max = Math.max(max, lds[i]+lis[i]-1);
        }
        System.out.println(max);

    }
    public static int search(int num, int idx, int[] arr){
        int left = 0;
        int right = idx;

        while (left < right){
            int mid = (left+right)/2;

            if(arr[mid] < num){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }
}