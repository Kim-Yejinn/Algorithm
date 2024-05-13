import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String search = br.readLine();

        int idx = 0;
        int cnt = 0;

        while (idx <= str.length() - search.length()){
            if(str.charAt(idx) == search.charAt(0)){
                boolean flag = true;
                for(int i=0; i<search.length(); i++){
                    if(str.charAt(idx+i) != search.charAt(i)){
                        idx++;
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    cnt++;
                    idx += search.length();
                }
            }else{
                idx++;
            }
        }
        System.out.println(cnt);
    }
}