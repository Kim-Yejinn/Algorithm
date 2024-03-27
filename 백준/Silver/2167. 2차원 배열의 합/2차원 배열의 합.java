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

        int[][] arr = new int[N+1][M+1];
        for(int r=1; r<=N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=1; c<=M; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
                arr[r][c] += arr[r-1][c] + arr[r][c-1] -arr[r-1][c-1];
            }
        }


        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            sb.append(arr[c][d] - arr[a-1][d] - arr[c][b-1] + arr[a-1][b-1]).append("\n");
        }
        System.out.println(sb);

    }
}