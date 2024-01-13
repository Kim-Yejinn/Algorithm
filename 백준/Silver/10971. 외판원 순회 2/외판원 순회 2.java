import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] dp;
    static int INF = 20000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new int[N][1<<N];

        StringTokenizer st = null;
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[r], -1);
        }

        System.out.println(dfs(1,0));
    }

    public static int dfs(int visit, int idx){
        if(visit == (1 << N)-1){
            if(arr[idx][0] == 0){
                return INF;
            }
            return arr[idx][0];
        }

        // 이미 값이 존재하는 경우
        if(dp[idx][visit] != -1){
            return dp[idx][visit];
        }

        dp[idx][visit] = INF;
        for(int i=0; i<N; i++){
            // 이미 방문했을 경우
            if((visit & (1<<i)) > 0){
                continue;
            }
            // 길이 없을 경우
            if(arr[idx][i] == 0){
                continue;
            }
            // 가자
            dp[idx][visit] = Math.min(dp[idx][visit], dfs(visit|(1<<i), i) + arr[idx][i]);
        }
        return dp[idx][visit];
    }
}