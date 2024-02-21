import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int r=0; r<N; r++){
            String str = br.readLine();

            for(int c=0; c<N; c++){
                arr[r][c] = str.charAt(c)-'0';
            }
        }
        sb = new StringBuilder();


        rec(0,0, N);

        System.out.println(sb);
    }

    public static void rec(int r, int c, int num){

        int ch = check(r, c, num);

        if(ch == -1){
            sb.append("(");
            rec(r, c, num/2);
            rec(r, c+num/2, num/2);
            rec(r+num/2, c, num/2);
            rec(r+num/2, c+num/2, num/2);

            sb.append(")");
        }else {
            sb.append(ch);
        }
    }
    public static int check(int R, int C, int num){

        int last = arr[R][C];

        for(int r=R; r<R+num; r++){
            for(int c=C; c<C+num; c++){
                if(last != arr[r][c]){
                    return -1;
                }
            }
        }
        return last;
    }
}