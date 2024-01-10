import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int H = 19;

        int[][] number = new int[M+1][H+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++){
            number[i][0] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<H; i++){
            for(int j=1; j<M+1; j++){
                number[j][i] = number[number[j][i-1]][i-1];
            }
        }

        int Q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for(int j=H-1; j>=0; j--){
                if((n & (1<<j)) > 0){
                    x = number[x][j];
                }
            }
            sb.append(x).append("\n");
        }
        System.out.println(sb);


    }
}