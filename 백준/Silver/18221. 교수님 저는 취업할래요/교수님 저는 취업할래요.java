import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int r;
        int c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][N+1];

        Node prof = new Node(0, 0);
        Node sung = new Node(0, 0);

        StringTokenizer st;
        for(int r=1; r<=N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=1; c<=N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
                if(arr[r][c] == 5){
                    prof = new Node(r, c);
                }
                if(arr[r][c] == 2){
                    sung = new Node(r, c);
                }
            }
        }

        int dis = (int) Math.sqrt(Math.pow(prof.r - sung.r, 2) + Math.pow(prof.c - sung.c, 2));
        int ans = 0;

        if(dis >= 5){
            int cnt = 0;

            int sr = Math.min(prof.r, sung.r);
            int sc = Math.min(prof.c, sung.c);

            int er = Math.max(prof.r, sung.r);
            int ec = Math.max(prof.c, sung.c);

            for(int r=sr; r<= er; r++){
                for(int c=sc; c<=ec; c++){
                    if(arr[r][c] == 1){
                        cnt++;
                    }
                }
            }
            if(cnt >= 3){
                ans = 1;
            }
        }
        System.out.println(ans);
    }
}