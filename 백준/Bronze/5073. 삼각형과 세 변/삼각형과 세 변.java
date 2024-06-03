import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a== 0 && b == 0 && c==0){
                break;
            }
            if(b<c){
                int t = c;
                c = b;
                b = t;
            }

            if(a<b){
                int t = b;
                b = a;
                a = t;
            }

            if(b<c){
                int t = c;
                c = b;
                b = t;
            }

            if(a >= b+c){
                sb.append("Invalid").append("\n");
            }else {
                if(a == b && b == c){
                    sb.append("Equilateral").append("\n");
                }else{
                    if(a == b || b == c){
                        sb.append("Isosceles").append("\n");
                    }else{
                        sb.append("Scalene").append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}