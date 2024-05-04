import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String input;
    static int N;
    static int len;
    static String ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        len = input.length();

        if(len > 9){
            N = (len-9) / 2 + 9;
        }else{
            N = len;
        }
        ans = "";

        rec(0, 0, "");
        System.out.println(ans);
    }
    public static void rec(int idx, long visit, String str){
        if(ans.length() > 0){
            return;
        }
        if(idx == len){
            ans = str;
            return;
        }

        int t = 0;

        for(int i=idx; i<len; i++){
            t = t*10 + (input.charAt(i) -'0');
            if(t > N){
                break;
            }
            if((visit & (1L << t)) > 0){
                continue;
            }

            rec(i+1, visit | (1L <<t), str + t+" ");
        }
    }
}