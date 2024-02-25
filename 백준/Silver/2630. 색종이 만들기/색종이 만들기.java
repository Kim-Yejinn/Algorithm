import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int blue;
    static int white;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        blue = 0;
        white = 0;

        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        rec(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void rec(int R, int C, int num){

        int last = arr[R][C];
        boolean flag = false;
        for(int r=R; r<R+num; r++){
            for(int c=C; c<C+num; c++){
                // 다를 경우
                if(last != arr[r][c]){
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        if(flag){
            // 다를 경우
            int div = num/2;
            rec(R, C, div);
            rec(R+div, C, div);
            rec(R, C+div, div);
            rec(R+div, C+div, div);
        }else{
            // 같을 경우
            if(last == 1){
                blue++;
            }else{
                white++;
            }
        }
    }
}