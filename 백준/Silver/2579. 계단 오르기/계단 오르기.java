
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] score = new int[N+1];
        for(int i=1; i<=N; i++){
            score[i] = sc.nextInt();
        }
        int[] dp = new int[N+1];
        dp[1] = score[1];
        if(N>=2){
            dp[2] = dp[1]+score[2];
        }

        for(int i=3; i<=N; i++){
            int num1 = dp[i-2];
            int num2 = score[i-1]+dp[i-3];

            int max= 0;
            if(num1>num2){
                max = num1;
            }else{
                max = num2;
            }

            dp[i] = max+score[i];
        }
        System.out.println(dp[N]);

    }
}
