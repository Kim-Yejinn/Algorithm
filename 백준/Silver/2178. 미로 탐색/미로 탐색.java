import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] dr = {0,0,-1,1};
        int[] dc = {-1,1,0,0};

        int[][] arr = new int[N][M];
        boolean[][] visit = new boolean[N][M];

        for(int r=0; r<N; r++){
            String str = sc.next();
            for(int c=0; c<M; c++){
                arr[r][c] = str.charAt(c)-'0';
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0, 1));
        visit[0][0] = true;

        int ans = 0;

        while(!q.isEmpty()){
            Node temp = q.poll();

            if(temp.r == N-1 && temp.c == M-1){
                ans = temp.cnt;
                break;
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
                if(arr[nr][nc]==0){
                    continue;
                }
                visit[nr][nc] = true;
                q.offer(new Node(nr, nc, temp.cnt+1));
            }
        }
        System.out.println(ans);
    }
}