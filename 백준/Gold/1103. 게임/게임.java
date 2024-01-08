import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean check;
    static int ans;
    static char[][] arr;
    static boolean[][] visit;
    static int[][] dp;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visit = new boolean[N][M];
        dp = new int[N][M];

        check = false;
        ans = 0;

        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=0; c<M; c++){
                arr[r][c] = str.charAt(c);
            }
        }

        dfs(0,0,1);

        if(check){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }
    public static void dfs(int r, int c, int cnt){
        if(check){
            return;
        }
        if(cnt>ans){
            ans = cnt;
        }
        dp[r][c] = cnt;

        int num = arr[r][c]-'0';
        for(int i=0; i<4; i++){
            int nr = r+dr[i]*num;
            int nc = c+dc[i]*num;

            if(nr<0||nc<0||nr>=N||nc>=M){
                continue;
            }
            if(visit[nr][nc]){
                check = true;
                return;
            }
            if(arr[nr][nc] == 'H'){
                continue;
            }
            if(dp[nr][nc]>cnt){
                continue;
            }
            visit[nr][nc] = true;
            dfs(nr, nc, cnt+1);
            visit[nr][nc] = false;
        }

    }
}