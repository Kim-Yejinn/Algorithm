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
    static int R;
    static int C;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];

        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                arr[r][c] = str.charAt(c);
            }
        }

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int t = Integer.parseInt(st.nextToken());
            if(i%2 == 0){
                // 왼
                leftBreak(R - t);
            }else{
                // 오
                rightBreak(R - t);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                sb.append(arr[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static boolean check(int r, int c){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visit = new boolean[R][C];
        boolean res = false;

        if(arr[r][c] == 'x'){
            q.offer(new Node(r, c));
            visit[r][c] = true;
        }else{
            res = true;
        }

        while (!q.isEmpty()){
            Node temp = q.poll();

            if(temp.r == R-1){
                res = true;
                break;
            }

            for(int i=0; i<4; i++){
                int nr = temp.r + dr[i];
                int nc = temp.c + dc[i];

                if(nr<0|| nc<0|| nr>=R || nc>=C){
                    continue;
                }
                if(visit[nr][nc]){
                    continue;
                }
                if(arr[nr][nc] != 'x'){
                    continue;
                }
                visit[nr][nc] = true;
                q.offer(new Node(nr, nc));
            }
        }
        return res;
    }

    public static void move(int r, int c){

        Queue<Node> q = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        boolean[][] visit = new boolean[R][C];
        boolean[][] copy = new boolean[R][C];

        q.offer(new Node(r, c));
        q2.offer(new Node(r, c));

        visit[r][c] = true;
        copy[r][c] = true;
        arr[r][c] = '.';


        while (!q.isEmpty()){
            Node temp = q.poll();

            for(int i=0; i<4; i++){
                int nr = temp.r + dr[i];
                int nc = temp.c + dc[i];

                if(nr<0|| nc<0|| nr>=R || nc>=C){
                    continue;
                }
                if(visit[nr][nc]){
                    continue;
                }
                if(arr[nr][nc] == '.'){
                    continue;
                }

                visit[nr][nc] = true;
                arr[nr][nc] = '.';
                copy[nr][nc] = true;

                q.offer(new Node(nr, nc));
                q2.offer(new Node(nr, nc));
            }
        }

        int min = R - 1;

        while (!q2.isEmpty()){
            Node t = q2.poll();
            min = Math.min(min, R - t.r -1);

            for(int j=R-1; j>t.r; j--){
                if(arr[j][t.c] == 'x'){
                    min = Math.min(min, j - t.r - 1);
                }
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(copy[i][j]){
                    arr[i+min][j] = 'x';
                }
            }
        }
    }
    public static void leftBreak(int H){
        int idx = -1;
        for(int i=0; i<C; i++){
            if(arr[H][i] == 'x'){
                arr[H][i] = '.';
                idx = i;
                break;
            }
        }
        if(idx != -1){
            // 위쪽 덩어리
            if(H != 0 && !check(H-1, idx)){
                move(H-1, idx);
            }
            // 왼쪽 덩어리
            if(idx !=0 && !check(H, idx-1)){
                move(H, idx-1);
            }
            // 오른쪽 덩어리
            if(idx !=C-1 && !check(H, idx+1)){
                move(H, idx+1);
            }
            // 아래 덩어리
            if(H != R-1 && !check(H+1, idx)){
                move(H+1, idx);
            }
        }
    }
    public static void rightBreak(int H){
        int idx = -1;
        for(int i=C-1; i>=0; i--){
            if(arr[H][i] == 'x'){
                arr[H][i] = '.';
                idx = i;
                break;
            }
        }

        if(idx != -1){
            // 위쪽 덩어리
            if(H != 0 && !check(H-1, idx)){
                move(H-1, idx);
            }
            // 왼쪽 덩어리
            if(idx !=0 && !check(H, idx-1)){
                move(H, idx-1);
            }
            // 오른쪽 덩어리
            if(idx !=C-1 && !check(H, idx+1)){
                move(H, idx+1);
            }
            // 아래 덩어리
            if(H != R-1 && !check(H+1, idx)){
                move(H+1, idx);
            }
        }
    }
}