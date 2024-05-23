import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static int[] sel;
    static int[] arr;
    static int N;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = 0;

        arr = new int[N+1];
        sel = new int[N+1];
        visit = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        rec(0);
        System.out.println(max);
    }
    public static void cal(){
        int sum = 0;
        for(int i=0; i<N-1; i++){
            sum += Math.abs(arr[sel[i]] - arr[sel[i+1]]);
        }
        max = Math.max(sum, max);
    }
    public static void rec(int num){
        if(num == N){
            cal();
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visit[i]){
                visit[i] = true;
                sel[num] = i;
                rec(num+1);
                visit[i] = false;
            }
        }
    }
}