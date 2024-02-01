import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = 0;
        for(int i=0; i<N; i++){
            String str = sc.next();
            int last = -1;
            boolean ans = true;
            boolean[] check = new boolean[26];

            for(int j=0; j<str.length(); j++){
                int t = str.charAt(j)-'a';

                if(check[t] && (last != t)){
                    ans = false;
                    break;
                }else{
                    check[t] = true;
                    last = t;
                }
            }

            if(ans){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}