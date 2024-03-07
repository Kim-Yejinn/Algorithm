import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int T;

    static int K;
    static int A;
    static int B;

    static char[][] arr;
    static int[][] sum;
    static int[][] temp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new char[N][M+1];
        sum = new int[N][M+1];
        temp = new int[N][M+1];

        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=1; c<=M; c++){
                arr[r][c] = str.charAt(c-1);
                temp[r][c] = temp[r][c-1];

                if(arr[r][c] == '*'){
                    temp[r][c]++;
                }
            }
        }

        for(int t=0; t<T; t++){
            init();
            for(int r=0; r<N; r++){
                for(int c=1; c<=M; c++) {
                    int ret = count(r, c);

                    if(arr[r][c] == '*'){
                        ret--;
                        if(ret < A || ret > B){
                            arr[r][c] = '.';
                            lineUpdate(r, c, -1);
                        }

                    }else{
                        // 생명
                        if(ret > A && ret <=B){
                            arr[r][c] = '*';
                            lineUpdate(r, c, 1);
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int r=0; r<N; r++){
            for(int c=1; c<=M; c++){
                sb.append(arr[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }
    public static void init(){
        for(int r=0; r<N; r++){
            for(int c=0; c<=M; c++){
                sum[r][c] = temp[r][c];
            }
        }
    }
    public static void lineUpdate(int r, int c, int v){
        for(int i=c; i<=M; i++){
            temp[r][i] += v;
        }
    }

    public static int count(int r, int c){
        int cnt = 0;
        int left = c-K-1;
        int right = c+K;

        if(left < 0) {
            left = 0;
        }
        if( right >= M){
            right = M;
        }
        for(int i=r-K; i<= r+K; i++){
            if(i < 0 || i >= N ){
                continue;
            }
            cnt += sum[i][right] - sum[i][left];
        }
        return cnt;
    }
}