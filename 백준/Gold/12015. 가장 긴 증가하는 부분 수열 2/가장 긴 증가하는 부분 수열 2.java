import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp = new int[N];

        int size = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = A[0];

        for(int i=1; i<N; i++){
            if(dp[size-1] < A[i]){
                dp[size++] = A[i];
            }else{
                int idx = search(A[i], size-1);
                dp[idx] = A[i];
            }
        }
        System.out.println(size);
    }
    public static int search(int num, int fin){
        int left = 0;
        int right = fin;

        while (left < right){
            int mid = (left+right) /2;

            if(dp[mid] < num){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }
}