import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int r;
        int c;
        int cnt;
        int wall;

        Node(int r, int c, int cnt, int wall){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        boolean[][][] visit = new boolean[11][N][M];

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int ans = -1;

        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=0; c<M; c++){
                arr[r][c] = str.charAt(c) - '0';
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, K));
        visit[K][0][0] = true;

        while (!q.isEmpty()){
            Node temp = q.poll();

            if(temp.r == N-1 && temp.c == M-1){
                ans = temp.cnt;
                break;
            }

            for(int i=0; i<4; i++){
                int nr = temp.r + dr[i];
                int nc = temp.c + dc[i];

                if(nr<0 || nc<0 || nr>=N || nc>=M){
                    continue;
                }

                if(arr[nr][nc] == 1){
                    if(temp.wall>0 && !visit[temp.wall-1][nr][nc]){
                        visit[temp.wall-1][nr][nc] = true;
                        q.offer(new Node(nr, nc, temp.cnt+1, temp.wall-1));
                    }
                }else{
                    if(!visit[temp.wall][nr][nc]){
                        visit[temp.wall][nr][nc] = true;
                        q.offer(new Node(nr, nc, temp.cnt+1, temp.wall));
                    }
                }

            }
        }
        System.out.println(ans);
    }
}