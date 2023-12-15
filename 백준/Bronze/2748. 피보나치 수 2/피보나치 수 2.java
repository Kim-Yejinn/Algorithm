
import java.util.Scanner;

public class Main {
    static long[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        memo = new long[N+1];

        System.out.println(pibo(N));

    }

    public static long pibo(int num){
        if(num == 0){
            return 0;
        }
        if(num == 1) {
            return 1;
        }

        if(memo[num]!=0){
            return memo[num];
        }
        return memo[num] = pibo(num-1)+pibo(num-2);

    }
}
