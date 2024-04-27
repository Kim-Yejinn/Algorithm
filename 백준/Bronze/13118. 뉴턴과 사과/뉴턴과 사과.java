import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] p = new int[5];

        for(int i=1; i<5; i++){
            p[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        int r = sc.nextInt();

        int ans = 0;
        for(int i=1; i<5; i++){
            if(x == p[i]){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}