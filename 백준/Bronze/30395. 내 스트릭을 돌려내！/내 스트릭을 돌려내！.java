import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] check = new boolean[N+3];
        check[0] = true;

        int max = 0;
        int cnt = 0;

        for(int i=1; i<=N; i++){
            int t = Integer.parseInt(st.nextToken());
            check[i] = check[i-1] | check[i];

            if(t == 0){
                if(check[i]){
                    check[i] = false;
                    check[i+2] = true;
                }else{
                    cnt = 0;
                }
            }else{
                cnt++;
            }
            max = Math.max(cnt, max);
        }
        System.out.println(max);

    }
}