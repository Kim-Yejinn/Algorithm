import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S;
    static String T;
    static boolean ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        ans = false;
        rec(T);

        if(ans){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
    public static void rec(String str){
        if(str.equals(S)){
            ans = true;
            return;
        }
        if(str.length() == S.length()){
            return;
        }

        if(str.charAt(0) == 'B'){
            String temp = str.substring(1);
            StringBuilder sb = new StringBuilder(temp);
            rec(sb.reverse().toString());
        }
        if(str.charAt(str.length()-1) == 'A'){
            rec(str.substring(0, str.length()-1));
        }
    }
}