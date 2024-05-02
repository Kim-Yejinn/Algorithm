import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][N+1];
        int INF = 987654321; // 아무값
        // 초기값 설정
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                arr[i][j] = INF;
                if(i == j){
                    // 나 자신까지의 거리
                    arr[i][j] = 0;
                }
            }
        }

        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 출발 -> 도착 이 같지만 다른 시간이 들어올 수도 있으니까!
            arr[a][b] = Math.min(arr[a][b], c);
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    // i -> j 까지 거리와 k를 거치는 거리를 비교한다
                    // i-> ?? -> j 와 i->k + k-> j 를 비교하는 것!
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(arr[i][j] == INF){
                    // 갈수 없는 경우
                    arr[i][j] = 0;
                }
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}