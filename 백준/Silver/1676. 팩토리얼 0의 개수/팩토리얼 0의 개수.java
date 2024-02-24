import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String str = String.valueOf(fac(N));

        int cnt = 0;
        for(int i=str.length()-1; i>=0; i--){
            int t = str.charAt(i)-'0';

            if(t == 0){
                cnt++;
            }else{
                break;
            }
        }
        System.out.println(cnt);
    }
    public static BigInteger fac(int N){
        if(N == 0){
            return BigInteger.ONE;
        }
        if(N == 1){
            return BigInteger.ONE;
        }

        return fac(N-1).multiply(BigInteger.valueOf(N));
    }

}