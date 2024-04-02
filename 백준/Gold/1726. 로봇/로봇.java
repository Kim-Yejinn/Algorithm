import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {0, 0, 0, 1, -1};
    static int[] dc = {0, 1, -1, 0, 0};

    static int right(int num){
        if(num == 1){
            return 3;
        }else if(num == 2){
            return 4;
        }else if(num == 3){
            return 2;
        }else if(num == 4){
            return 1;
        }
        return 0;
    }

    static int left(int num){
        if(num == 1){
            return 4;
        }else if(num == 2){
            return 3;
        }else if(num == 3){
            return 1;
        }else if(num == 4){
            return 2;
        }
        return 0;
    }

    static class Node{
        int r;
        int c;
        int dir;
        int cnt;

        Node(int r, int c, int dir, int cnt){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        boolean[][][] visit = new boolean[5][N][M];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken())-1;
        int sc = Integer.parseInt(st.nextToken())-1;
        int sd = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int er = Integer.parseInt(st.nextToken())-1;
        int ec = Integer.parseInt(st.nextToken())-1;
        int ed = Integer.parseInt(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sr, sc, sd, 0));
        visit[sd][sr][sc] = true;

        while (!q.isEmpty()){
            Node temp = q.poll();

            if(temp.r == er && temp.c == ec && temp.dir == ed){
                System.out.println(temp.cnt);
                break;
            }


            for(int k=1; k<4; k++){
                int nr = temp.r + k*dr[temp.dir];
                int nc = temp.c + k*dc[temp.dir];

                if(nr<0 || nc<0 || nr>=N || nc>=M){
                    continue;
                }
                if(arr[nr][nc] == 1){
                    break;
                }
                if(visit[temp.dir][nr][nc]){
                    continue;
                }
                visit[temp.dir][nr][nc] = true;
                q.offer(new Node(nr, nc, temp.dir, temp.cnt+1));
            }

            int next = right(temp.dir);
            if(!visit[next][temp.r][temp.c]){
                visit[next][temp.r][temp.c] = true;
                q.offer(new Node(temp.r, temp.c, next, temp.cnt+1));
            }
            next = left(temp.dir);
            if(!visit[next][temp.r][temp.c]){
                visit[next][temp.r][temp.c] = true;
                q.offer(new Node(temp.r, temp.c, next, temp.cnt+1));
            }
        }
    }
}