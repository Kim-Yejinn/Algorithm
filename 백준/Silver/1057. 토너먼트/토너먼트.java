import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int ans = 1;

        while (N>=2){
            A+=1;
            B+=1;
            if(A/2 == B/2){
                A/=2;
                B/=2;
                break;
            }else{
                N /= 2;
                A/=2;
                B/=2;
                ans ++;
            }
        }
        System.out.println(ans);
    }

}
