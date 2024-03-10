import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] rect = new int[H+3][W+3];
        int[][] dia = new int[H+3][W+3];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());
            if(op == 1){
                int px = Integer.parseInt(st.nextToken())+1;
                int py = Integer.parseInt(st.nextToken())+1;
                int qx = Integer.parseInt(st.nextToken())+1;
                int qy = Integer.parseInt(st.nextToken())+1;

                rect[py][px]++;
                rect[py][qx+1]--;
                rect[qy+1][px]++;
                rect[qy+1][qx+1]--;
            }else{
                int px = Integer.parseInt(st.nextToken())+1;
                int py = Integer.parseInt(st.nextToken())+1;
                int r = Integer.parseInt(st.nextToken());



                dia[py-r][px]++;
                dia[py+1][px+r+1]--;
                dia[py+1][px-r-1]--;
                dia[py+r+2][px]++;


                dia[py-r+1][px]++;
                dia[py+r+1][px]++;
                dia[py+1][px-r]--;
                dia[py+1][px+r]--;

            }
        }

        // 사각형
        // 가로
        for(int r=0; r<=H; r++){
            for(int c=1; c<=W; c++){
                rect[r][c] += rect[r][c-1];
            }
        }
        // 세로
        for(int c=0; c<=W; c++){
            for(int r=1; r<=H; r++){
                rect[r][c] += rect[r-1][c];
            }
        }

        // 대각선 좌->우하로
        for(int c=W; c>0; c--){
            for(int r=1, dc=c; r<=H && dc<=W; r++, dc++){
                dia[r][dc] += dia[r-1][dc-1];
            }
        }
        for(int r=2; r<=H; r++){
            for(int c=1, dr = r; c<=W && dr<=H; c++, dr++){
                dia[dr][c] += dia[dr-1][c-1];
            }
        }

        // 대각선 우-> 좌하
        for(int c=0; c<W; c++){
            for(int r=1, dc=c; r<=H && dc >= 0; r++, dc--){
                dia[r][dc] += dia[r-1][dc+1];
            }
        }

        for(int r=2; r<=H; r++){
            for(int c=W-1, dr=r; c>=0 && dr<=H; c--, dr++){
                dia[dr][c] += dia[dr-1][c+1];
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int r=1; r<=H; r++){
            for(int c=1; c<=W; c++){
                int num = rect[r][c] + dia[r][c];

                if(num %2 == 0){
                    sb.append(".");
                }else{
                    sb.append("#");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}