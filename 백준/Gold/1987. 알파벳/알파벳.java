import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static char[][] arr;
    static boolean[][] visit;
    static int ans;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                arr[r][c] = str.charAt(c);
            }
        }
        ans = 0;
        visit = new boolean[R][C];
        visit[0][0] = true;
        rec(0, 0, 1, 1<<(arr[0][0]-'A'));
        System.out.println(ans);
    }
    public static void rec(int r, int c, int cnt, int alphabet){
        ans = Math.max(ans, cnt);
        for(int i=0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];

            if(nr<0||nc<0||nr>=R||nc>=C){
                continue;
            }
            if(visit[nr][nc]){
                continue;
            }
            char next = arr[nr][nc];
            if((1<<(next-'A') & alphabet) > 0){
                continue;
            }
            visit[nr][nc] = true;
            rec(nr, nc, cnt+1, alphabet|(1<<(next-'A')));
            visit[nr][nc] = false;
        }
    }
}