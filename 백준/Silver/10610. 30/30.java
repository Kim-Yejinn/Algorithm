import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int sum = 0;
        int[] cnt = new int[10];

        for(int i=0; i<N.length(); i++){
            int t = N.charAt(i) - '0';
            sum += t;

            cnt[t]++;
        }


        if((cnt[0] != 0) && (sum%3 == 0)){
            StringBuilder sb = new StringBuilder();
            for(int i=9; i>=0; i--){
                for(int j=0; j<cnt[i]; j++){
                    sb.append(i);
                }
            }
            System.out.println(sb);
        }else{
            System.out.println(-1);
        }
    }
}