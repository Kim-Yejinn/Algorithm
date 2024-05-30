import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String input;
    static boolean[] visit;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        visit = new boolean[input.length()];
        ans = Integer.MAX_VALUE;

        rec(0, "");

        if(ans == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(ans);
        }
    }
    public static void rec(int idx, String temp){
        if(idx >= input.length()){
            if(Integer.parseInt(temp) > Integer.parseInt(input)){
                ans = Math.min(ans, Integer.parseInt(temp));
            }
            return;
        }

        for(int i=0; i<input.length(); i++){
            if(!visit[i]){
                visit[i] = true;
                rec(idx+1, temp+input.charAt(i));
                visit[i] = false;
            }
        }
    }

}