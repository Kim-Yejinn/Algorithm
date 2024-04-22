import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+3];
        boolean[] check = new boolean[N+3];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int t = Integer.parseInt(st.nextToken());
            check[t] = true;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<Q; i++){
            int t = Integer.parseInt(st.nextToken());
            if(check[t]){
                continue;
            }
            int sum = t;
            while (sum <= N+2) {
                if(!check[sum]){
                    arr[sum] = 1;
                }
                sum += t;
            }
        }

        for(int i=4; i<=N+2; i++){
            arr[i] += arr[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(E - S +1 - (arr[E] - arr[S-1])).append("\n");
        }
        System.out.println(sb);
    }
}