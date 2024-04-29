import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R;
    static int C;

    static int[][] map;
    static int[][][] arr;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static boolean[][] visit;

    static int MAX = 100_000;

    public static class Node{
        int r;
        int c;
        int cnt;
        Node(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        arr = new int[3][R][C];

        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                map[r][c] = str.charAt(c) - '0';
                arr[0][r][c] = arr[1][r][c] = arr[2][r][c] = MAX;
            }
        }

        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bfs(a-1, b-1, i);
        }

        int min = 3*MAX;
        int cnt = 0;

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(map[r][c] == 1){
                    continue;
                }
                int check = Math.max(arr[0][r][c], Math.max(arr[1][r][c], arr[2][r][c]));

                if(check == MAX){
                    continue;
                }
                if(min > check){
                    min = check;
                    cnt = 1;
                }else if(min == check){
                    cnt++;
                }
            }
        }
        if(min == 3*MAX){
            System.out.println(-1);
        }else{
            System.out.println(min);
            System.out.println(cnt);
        }
    }

    public static void bfs(int r, int c, int num){
        visit = new boolean[R][C];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c, 0));
        visit[r][c] = true;

        while (!q.isEmpty()){
            Node temp = q.poll();
            arr[num][temp.r][temp.c] = temp.cnt;

            for(int i=0; i<4; i++){
                int nr = temp.r + dr[i];
                int nc = temp.c + dc[i];

                if(nr<0 || nc<0|| nr>=R || nc>=C){
                    continue;
                }
                if(visit[nr][nc]){
                    continue;
                }
                if(map[nr][nc] == 1){
                    continue;
                }
                visit[nr][nc] = true;
                q.offer(new Node(nr, nc, temp.cnt+1));
            }
        }
    }
}