import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long S = sc.nextLong();

        int cnt = 0;
        long sum =0;

        for(int i=1; i<=S;i++){
            cnt++;
            sum+=i;
            if(sum>S){
                break;
            }
        }
        if(S==1){
            System.out.println(1);
        }else{
            System.out.println(cnt-1);
        }
    }
}