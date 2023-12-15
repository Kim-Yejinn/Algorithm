
import java.math.BigInteger;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        BigInteger[] arr = new BigInteger[30];

        BigInteger num = BigInteger.valueOf(1);

        for(int i=1; i<30; i++){
            num = num.multiply(BigInteger.valueOf(i));
            arr[i] = num;
        }


        for(int tc=0; tc<T; tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            if(M-N ==0){
                System.out.println(1);
            }else{
                System.out.println(arr[M].divide(arr[M-N].multiply(arr[N])));
            }
        }
    }

}
