import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[N+1];
        int[] arr = new int[N+1];

        dp[1] = arr[1] = sc.nextInt();

        if(N>=2){
            arr[2] = sc.nextInt();
            dp[2] = arr[1]+arr[2];
        }

        for(int i=3; i<=N; i++){
            arr[i] = sc.nextInt();

            int c1 = dp[i-2]+arr[i];
            int c2 = dp[i-3]+arr[i-1]+arr[i];
            int c3 = dp[i-1]; // 지금 것 선택 안한 경우

            int max = c1;
            if(max<c2){
                max = c2;
            }
            if(max<c3){
                max = c3;
            }
            dp[i] = max;
        }
        System.out.println(dp[N]);
    }
}