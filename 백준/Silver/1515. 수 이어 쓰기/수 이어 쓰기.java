import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int idx = 0;
        int ans = 0;

        for(int i=1; i<=100000; i++){
            String t = Integer.toString(i);

            for(int j=0; j<t.length(); j++){
                if(idx >= str.length()){
                    break;
                }
                int check = str.charAt(idx);
                int temp = t.charAt(j);

                if(check == temp){
                    idx++;
                    ans = i;
                }
            }
            if(idx >= str.length()){
                break;
            }
        }
        System.out.println(ans);
    }
}