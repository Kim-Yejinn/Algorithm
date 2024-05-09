import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int DIV = 1_000_000_007;
        int N = sc.nextInt();
        int[] dp = new int[N+1];
        if(N >= 1){
            dp[1] = 1;
        }
        for(int i=2; i<=N; i++){
            dp[i] = (dp[i-1]%DIV + dp[i-2]%DIV) %DIV;
        }
        System.out.println(dp[N]);
    }
}