import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        visit = new int[N][M];

        for(int r=0; r<N; r++){
            String str = sc.next();
            for(int c=0; c<M; c++){
                char t = str.charAt(c);

                if(t == 'U'){
                    arr[r][c] = 0;
                }else if(t == 'D'){
                    arr[r][c] = 1;
                }else if(t == 'L'){
                    arr[r][c] = 2;
                }else if(t == 'R'){
                    arr[r][c] = 3;
                }
            }
        }

        int cnt = 0;
        int num = 1;
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(visit[r][c]==0){
                    flag = false;
                    dfs(r,c, num);
                    if(!flag){
                        cnt++;
                    }
                    num++;
                }
            }
        }
        System.out.println(cnt);
    }
    public static void dfs(int r, int c, int num){
        int idx = arr[r][c];
        int nr = r+dr[idx];
        int nc = c+dc[idx];

        if(visit[nr][nc] == num){
            return;
        }
        if(visit[nr][nc] != 0){
            flag = true;
            return;
        }
        visit[nr][nc] = num;
        dfs(nr, nc, num);
    }
}