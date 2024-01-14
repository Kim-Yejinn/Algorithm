import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N+1];

        arr[0] =1;
        if(N>=2){
            arr[2] = 3;
        }
        for(int i=4; i<=N; i+=2){
            arr[i] = arr[i-2]*3;

            for(int j=4; j<=i; j++){
                arr[i] += arr[i-j]*2;
            }

        }
        System.out.println(arr[N]);
    }
}