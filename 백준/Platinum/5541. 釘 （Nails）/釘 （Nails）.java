import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+3][N+3];

        for(int i=0 ;i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b]++;
            arr[a][b+1]--;

            arr[a+c+1][b]--;
            arr[a+c+2][b+1]++;

            arr[a+c+1][b+c+2]++;
            arr[a+c+2][b+c+2]--;
        }
        // 가로
        for(int r=1; r<=N; r++){
            for(int c=1; c<=N; c++){
                arr[r][c] += arr[r][c-1];
            }
        }
        // 세로
        for(int r=1; r<=N; r++){
            for(int c=1; c<=r; c++){
                arr[r][c] += arr[r-1][c];
            }
        }
        // 대각
        for(int r=1; r<=N; r++){
            for(int c=1; c<=N; c++){
                arr[r][c] += arr[r-1][c-1];
            }
        }

        int cnt = 0;
        for(int r=1; r<=N; r++){
            for(int c=1; c<=r; c++){
                if(arr[r][c]>0){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}