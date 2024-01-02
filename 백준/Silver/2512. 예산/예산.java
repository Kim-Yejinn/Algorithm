import java.util.Scanner;

public class Main {
    static int[] arr;
    static int N;
    static int M;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N =sc.nextInt();
        arr = new int[N];
        max = 0;

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
            if(arr[i]>max){
                max = arr[i];
            }
        }
        M = sc.nextInt(); // int 범위

        int ans = find();
        System.out.println(ans);

    }
    public static int find(){
        int left = 1;
        int right = max;

        int result = 0;
        while (left<=right){
            int mid = (left+right)/2;

            if(check(mid)>M){
                right = mid-1;
            }else{
                left = mid+1;
                result = mid;
            }
        }
        return result;
    }
    public static int check(int num){
        int sum = 0;
        for(int i=0; i<N; i++){
            if(arr[i]<num){
                sum+=arr[i];
            }else{
                sum+=num;
            }
        }
        return sum;
    }
}