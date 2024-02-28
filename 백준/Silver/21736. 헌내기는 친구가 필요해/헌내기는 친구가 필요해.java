import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        boolean[][] visit = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();

        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=0; c<M; c++){
                arr[r][c] = str.charAt(c);
                if(arr[r][c]=='I'){
                    q.offer(new Node(r, c));
                    visit[r][c] = true;
                }
            }
        }

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int ans = 0;

        while (!q.isEmpty()){
            Node temp = q.poll();

            if(arr[temp.r][temp.c] == 'P'){
                ans++;
            }

            for(int i=0; i<4; i++){
                int nr = temp.r+dr[i];
                int nc = temp.c+dc[i];

                if(nr<0||nc<0||nr>=N||nc>=M){
                    continue;
                }
                if(visit[nr][nc]){
                    continue;
                }
                if(arr[nr][nc]=='X'){
                    continue;
                }
                q.offer(new Node(nr, nc));
                visit[nr][nc] = true;
            }
        }

        if(ans == 0){
            System.out.println("TT");
        }else{
            System.out.println(ans);
        }


    }
}