import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static class Node{
        int r;
        int c;
        int time;
        boolean knife;
        Node(int r, int c, int time, boolean knife){
            this.r = r;
            this.c = c;
            this.time = time;
            this.knife = knife;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        int[][] arr = new int[N][M];
        boolean[][][] visit = new boolean[2][N][M];

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                arr[r][c] = sc.nextInt();
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0, false));
        visit[0][0][0] = true;

        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()){
            Node temp = q.poll();

            if(temp.time>T){
                break;
            }
            if(temp.r == N-1 && temp.c == M-1){
                min = temp.time;
                break;
            }

            for(int i=0; i<4; i++){
                int nr = temp.r + dr[i];
                int nc = temp.c + dc[i];

                if(nr<0||nc<0||nr>=N||nc>=M){
                    continue;
                }
                if(temp.knife){
                    // 칼 있을 때
                    if(visit[1][nr][nc]){
                        continue;
                    }
                    q.offer(new Node(nr, nc, temp.time+1, true));
                    visit[1][nr][nc] = true;
                }else{
                    // 칼 없을때
                    if(visit[0][nr][nc]){
                        continue;
                    }
                    if(arr[nr][nc]==1){
                        continue;
                    }
                    if(arr[nr][nc] == 2){
                        q.offer(new Node(nr, nc, temp.time+1, true));
                        visit[1][nr][nc] = true;
                        visit[0][nr][nc] = true;
                    }else{
                        q.offer(new Node(nr, nc, temp.time+1, false));
                        visit[0][nr][nc] = true;
                    }
                }
            }
        }

        if(min == Integer.MAX_VALUE){
            System.out.println("Fail");
        }else{
            System.out.println(min);
        }

    }
}