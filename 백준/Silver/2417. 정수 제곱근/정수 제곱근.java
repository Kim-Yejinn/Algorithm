import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        long max = N;
        long min = 0;
        long result = 0;

        while(max>=min){
            long mid = (max+min)/2;
            double mul = Math.pow(mid,2);

            if(mul >= N){
                max = mid-1;
                result = mid;
            }else if(mul<N){
                min = mid+1;
            }
        }
        System.out.println(result);
    }
}