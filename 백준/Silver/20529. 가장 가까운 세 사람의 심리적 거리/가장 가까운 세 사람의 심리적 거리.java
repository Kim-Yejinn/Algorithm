import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String[] str;
    static int N;
    static int ans;
    static int[] sel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            if(N >= 33){
                System.out.println(0);
                continue;
            }

            str = new String[N];
            sel = new int[3];
            ans = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                str[i] = st.nextToken();
            }

            rec(0, 0);
            System.out.println(ans);
        }
    }
    public static void cal(){
        String a = str[sel[0]];
        String b = str[sel[1]];
        String c = str[sel[2]];

        int cnt = 0;
        for(int i=0; i<4; i++){
            if(a.charAt(i) != b.charAt(i)){
                cnt++;
            }
            if(a.charAt(i) != c.charAt(i)){
                cnt++;
            }
            if(b.charAt(i) != c.charAt(i)){
                cnt++;
            }
        }

        if(cnt < ans){
            ans = cnt;
        }
    }
    public static void rec(int num, int st){
        if(num == 3){
            cal();
            return;
        }
        for(int i=st; i<N; i++){
            sel[num] = i;
            rec(num+1, i+1);
        }
    }
}