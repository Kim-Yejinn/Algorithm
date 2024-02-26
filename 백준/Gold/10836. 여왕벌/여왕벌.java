import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[M][M];

        int[] num = new int[2*M];

        // 1_000_000
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            num[a] += 1;
            num[a + b] += 1;
        }

        int idx = 0;

        // 2*M-1 -> 1400
        for(int r=M-1; r>=0; r--){
            arr[r][0] = num[idx++];
            num[idx] += num[idx-1];
        }

        for(int c=1; c<M; c++){
            arr[0][c] = num[idx++];
            num[idx] += num[idx-1];
        }

        StringBuilder sb = new StringBuilder();

        // 700*700 = 49_000
        for(int r=0; r<M; r++){
            for(int c=0; c<M; c++){
                if(r==0 || c==0){
                    arr[r][c]++;
                    sb.append(arr[r][c]).append(" ");
                }else{
                    int a = Math.max(Math.max(arr[r-1][c-1], arr[r-1][c]), arr[r][c-1]);
                    arr[r][c] = a;
                    sb.append(arr[r][c]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}