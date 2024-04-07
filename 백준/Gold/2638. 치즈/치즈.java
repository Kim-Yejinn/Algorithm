import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] isAir;
    static boolean[][] visit;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;

        while (true){
            if(isEnd()){
                break;
            }
            time++;
            init();
            remove();
        }
        System.out.println(time);
    }

    public static void remove(){
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(arr[r][c] == 0){
                    continue;
                }
                int cnt = 0;
                for(int i=0; i<4; i++){
                    int nr = r+dr[i];
                    int nc = c+dc[i];

                    if(nr<0 || nc<0 || nr>=N || nc>=M){
                        continue;
                    }

                    if(isAir[nr][nc]){
                        cnt++;
                    }
                }

                if(cnt >= 2){
                    arr[r][c] = 0;
                }
            }
        }
    }

    public static boolean isEnd(){
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(arr[r][c] == 1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void init(){
        visit = new boolean[N][M];
        isAir = new boolean[N][M];

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        visit[0][0] = true;
        isAir[0][0] = true;

        while (!q.isEmpty()){
            Node temp = q.poll();

            for(int i=0; i<4; i++){
                int nr = temp.r + dr[i];
                int nc = temp.c + dc[i];

                if(nr<0 || nc<0 || nr>=N || nc>=M){
                    continue;
                }
                if(arr[nr][nc] == 1){
                    continue;
                }
                if(visit[nr][nc]){
                    continue;
                }
                visit[nr][nc] = true;
                isAir[nr][nc] = true;
                q.offer(new Node(nr, nc));
            }
        }
    }
}