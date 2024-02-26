import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[M][M];

        for(int r=0; r<M; r++){
            for(int c=0; c<M; c++){
                arr[r][c] += 1;
            }
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int[] num = new int[3];

            num[0] = Integer.parseInt(st.nextToken());
            num[1] = Integer.parseInt(st.nextToken());
            num[2] = Integer.parseInt(st.nextToken());

            for(int r=M-1; r>=0; r--){
                if(num[0] > 0){
                    arr[r][0] += 0;
                    num[0]--;
                }else if(num[1] > 0){
                    arr[r][0] += 1;
                    num[1]--;
                }else{
                    arr[r][0] += 2;
                    num[2]--;
                }
            }

            for(int c=1; c<M; c++){
                if(num[0] > 0){
                    arr[0][c] += 0;
                    num[0]--;
                }else if(num[1] > 0){
                    arr[0][c] += 1;
                    num[1]--;
                }else{
                    arr[0][c] += 2;
                    num[2]--;
                }
            }
        }
        for(int r=1; r<M; r++){
            for(int c=1; c<M; c++){
                int num = Math.max(Math.max(arr[r-1][c-1], arr[r-1][c]), arr[r][c-1]);
                arr[r][c] = num;
            }
        }

        for(int r=0; r<M; r++){
            for(int c=0; c<M; c++){
                System.out.print(arr[r][c]+" ");
            }
            System.out.println();
        }
    }
}