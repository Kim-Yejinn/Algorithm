import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int idxA = A.length()-1;
        int idxB = B.length()-1;

        StringBuilder sb = new StringBuilder();

        int next = 0;
        while (idxA != -1 || idxB != -1){
            int a;
            int b;

            if(idxA == -1){
                a = 0;
            }else {
                a = A.charAt(idxA)-'0';
                idxA--;
            }
            if(idxB == -1){
                b = 0;
            }else {
                b = B.charAt(idxB)-'0';
                idxB--;
            }

            int sum = a+b+next;
            sb.append(sum %10);
            next = sum/10;
        }
        if(next!=0){
            sb.append(next);
        }
        System.out.println(sb.reverse());
    }
}