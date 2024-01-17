import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N;
    static int cnt;
    static boolean[] check;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            N  = Integer.parseInt(br.readLine());

            arr = new int[N+1];
            check = new boolean[N+1];
            visit = new boolean[N+1];
            cnt =0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=N; i++){
                if(check[i]){
                    continue;
                }
                rec(i);
            }
            System.out.println(N-cnt);

        }
    }
    public static void rec(int num){
        if(check[num]){
            return;
        }
        if(visit[num]){
            check[num] = true;
            cnt++;
        }
        visit[num] = true;
        rec(arr[num]);
        check[num] = true;
        visit[num] = false;

    }
}