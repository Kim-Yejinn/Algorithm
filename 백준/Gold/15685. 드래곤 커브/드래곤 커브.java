import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] arr = new boolean[101][101];

        int N = Integer.parseInt(br.readLine());
        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};

        for(int t=0; t<N; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();

            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int gen = Integer.parseInt(st.nextToken());

            arr[r][c] = true;
            r += dr[dir];
            c += dc[dir];
            arr[r][c] = true;
            list.add(dir);

            for(int i=0; i<gen; i++){
                // 역방향
                for(int j = list.size()-1; j>=0; j--){
                    int next = (list.get(j) + 1) % 4;
                    r += dr[next];
                    c += dc[next];
                    arr[r][c] = true;
                    list.add(next);
                }
            }
        }

        int ans = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(arr[i][j] && arr[i+1][j] && arr[i][j+1] && arr[i+1][j+1]){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}