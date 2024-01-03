import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        int[] arr = new int[K];

        int max = 0;

        for(int i=0; i<K; i++){
            arr[i] = sc.nextInt();
            if(arr[i]>max){
                max = arr[i];
            }
        }

        long left = 1;
        long right = max;
        long result = 0;

        while(left<=right){
            long mid = (left+right)/2;

            long sum = 0;
            for(int i=0; i<K; i++){
                sum += arr[i]/mid;
            }

            if(sum>=N){
                result = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(result);
    }
}