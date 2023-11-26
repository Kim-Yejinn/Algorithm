
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int num = 0;
        int ans = 0;
        boolean last = false;
        for(int i=0; i<str.length(); i++){
            char temp = str.charAt(i);

            if(temp == '('){
                num++;
                last = true;
            }else if(temp == ')'){
                if(last){
                    ans +=(num-1);
                    num--;
                }else{
                    num--;
                    ans++;
                }
                last = false;
            }
        }

        System.out.println(ans);


    }
}
