import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int J = Integer.parseInt(br.readLine());

        int cnt = 0;
        int left = 1;
        int right = left+M-1;

        for(int j=0; j<J; j++){
            int t = Integer.parseInt(br.readLine());

            if(t < left){
                cnt += left - t;
                left = t;
                right = left + M -1;
            }else if( right < t){
                cnt += t - right;
                right = t;
                left = right - M +1;
            }

        }
        System.out.println(cnt);
    }
}