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

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for(int j=0; j<M; j++){
            B[j] = Integer.parseInt(st.nextToken());
        }

        int a_idx = 0;
        int b_idx = 0;


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N+M; i++){
            if(a_idx >= N){
                sb.append(B[b_idx++]).append(" ");
                continue;
            }
            if(b_idx >= M){
                sb.append(A[a_idx++]).append(" ");
                continue;
            }
            if(A[a_idx]>B[b_idx]){
                sb.append(B[b_idx++]).append(" ");
            }else{
                sb.append(A[a_idx++]).append(" ");
            }
        }
        System.out.println(sb);
    }
}