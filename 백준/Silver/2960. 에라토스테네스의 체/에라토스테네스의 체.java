import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean[] arr=  new boolean[N+1];

        int cnt = 0;
        int ans = 0;
        for(int i=2; i<=N; i++){
            if(!arr[i]){
                for(int j=1; j*i<=N; j++){
                    int num = j*i;
                    if(arr[num]){
                        continue;
                    }
                    arr[num] = true;
                    cnt++;
                    if(cnt ==K){
                        ans = num;
                        break;
                    }
                }
            }
            if(ans != 0){
                break;
            }
        }
        System.out.println(ans);

    }
}