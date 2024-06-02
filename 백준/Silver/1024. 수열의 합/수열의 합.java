import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i=L; i<=100; i++){
            int res = cal(N, i-1);
            if(res == -1){
                continue;
            }else{
                for(int j=0; j<i; j++){
                    sb.append(res+j).append(" ");
                }
                break;
            }
        }

        if(sb.length() >0){
            System.out.println(sb);
        }else{
            System.out.println(-1);
        }
    }
    // 시작 점 찾기
    public static int cal(int n, int len){
        int num = 2 * n - len * len - len;
        int den = 2 * len + 2;
        if(num >= 0 && num % den == 0){
            return num / den;
        }else{
            return -1;
        }
    }
}