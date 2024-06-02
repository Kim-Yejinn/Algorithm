import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] dp;
    static boolean[][] visit;

    static int ans = 0;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new int[N][N];
        visit = new boolean[N][N];

        StringTokenizer st;
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
                dp[r][c] = -1;
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                visit[r][c] = true;
                int temp = rec(r,c,0);
                dp[r][c] = Math.max(1, temp);
                visit[r][c] = false;
                ans = Math.max(ans, dp[r][c]);
            }
        }

        System.out.println(ans);
    }

    public static int rec(int r, int c, int cur){
        int temp = 1;

        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr<0||nc<0||nr>=N||nc>=N){
                continue;
            }
            if(visit[nr][nc]){
                continue;
            }
            if(arr[r][c] >= arr[nr][nc]){
                continue;
            }
            if(dp[nr][nc] != -1){
                temp = Math.max(dp[nr][nc]+1, temp);
                continue;
            }
            visit[nr][nc] = true;
            temp = Math.max(temp, 1+rec(nr, nc, cur+1));
            dp[r][c] = temp;
            visit[nr][nc] = false;
        }
        return temp;
    }
}