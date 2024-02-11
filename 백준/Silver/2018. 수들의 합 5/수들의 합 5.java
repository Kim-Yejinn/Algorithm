import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int right = 1;
        int left = 1;
        int cnt = 0;
        long sum = 1;
        while (right <= N){
            if(sum == N){
                sum -= left;
                left++;
                right++;
                sum += right;
                cnt++;
            }else if(sum < N){
                right++;
                sum+=right;
            }else{
                sum -= left;
                left++;
            }
        }
        System.out.println(cnt);
    }
}