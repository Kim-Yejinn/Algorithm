
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr =new int[N+1];
        for(int i=1; i<=N; i++){
            int num = (int) Math.sqrt(i);
            int min = 5;

            for(int j=1; j<=num; j++){
                // j제곱을 한번 더할경우
                // 이전 것에 +1이 됨
                // 이전 값이 가장 작은 것을 찾아야함.
                // 이전 값은 arr[i-j*j];
                int last = arr[i-j*j];

                if(min>last){
                    min = last;
                }
            }
            arr[i] = min+1;
        }

        System.out.println(arr[N]);
    }
}
