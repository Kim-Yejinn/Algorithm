import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int mod = 1000000000;

        // 해당 숫자로 끝나는 N자리
        int[][] dp = new int[N+1][10];

        // 초기 값 넣기
        for(int i=1; i<10; i++){
            dp[1][i] = 1;
        }
        
        // N까지 돌리면서 값 채우기
        for(int i=2; i<=N; i++){
            for(int j=1; j<9; j++){
                dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%mod;
            }
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];
        }

        // N번을 다 더하면 답임
        int sum = 0;
        for(int i=0; i<10; i++){
            sum = (sum+dp[N][i])%mod;
        }

        System.out.println(sum);
    }
}