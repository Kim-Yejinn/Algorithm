
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp =  new int[N+1];
        
        if(N>=2){
            dp[2] = 1;
        }
        if(N>=3){
            dp[3] = 1;
        }

        for(int i=4; i<=N; i++){
            int min = Integer.MAX_VALUE;
            if(min>dp[i-1]){
                min = dp[i-1];
            }
            if(i%2==0 && min>dp[i/2]){
                min = dp[i/2];
            }
            if(i%3 ==0 && min>dp[i/3]){
                min = dp[i/3];
            }
            dp[i] = min+1;
        }
        System.out.println(dp[N]);
    }
}
