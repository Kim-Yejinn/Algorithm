
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        int ans = 0;

        for(int i=1; i<=N; i++){
            arr[i] = sc.nextInt();
            int sum = 0;
            for(int j=1; j<i; j++){
                if(arr[j]<arr[i] && dp[j]>sum){
                    sum = dp[j];
                }
            }
            dp[i] = sum+arr[i];
            if(dp[i]>ans){
                ans = dp[i];
            }
        }
        System.out.println(ans);

    }
}
