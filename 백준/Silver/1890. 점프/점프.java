
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N =sc.nextInt();

        long[][] cnt = new long[N][N];

        int[] dr = {1,0};
        int[] dc = {0,1};

        cnt[0][0] = 1;

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                int input = sc.nextInt();

                if(input == 0){
                    continue;
                }

                for(int d=0; d<2; d++){
                    int nr = r+dr[d]*input;
                    int nc = c+dc[d]*input;

                    if(nr<0||nc<0||nr>=N||nc>=N){
                        continue;
                    }
                    cnt[nr][nc]+=cnt[r][c];
                }
            }

        }

        System.out.println(cnt[N-1][N-1]);

    }
}
