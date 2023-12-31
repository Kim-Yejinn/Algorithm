import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 1. Scanner 시초나는 문제
    
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] ans = new int[N][M];
        boolean[][] visit = new boolean[N][M];

        int stR = 0;
        int stC = 0;
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
                if(arr[r][c] != 0){
                    ans[r][c] = -1;
                }
                if(arr[r][c]==2){
                    stR = r;
                    stC = c;
                }
            }
        }

        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(stR, stC, 0));
        visit[stR][stC] = true;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()){
            Node temp = q.poll();

            ans[temp.r][temp.c] = temp.cnt;

            for(int i=0; i<4; i++){
                int nr = temp.r + dr[i];
                int nc = temp.c + dc[i];

                if(nr<0||nc<0||nr>=N||nc>=M){
                    continue;
                }
                if(visit[nr][nc]){
                    continue;
                }
                if(arr[nr][nc] == 0){
                    continue;
                }
                visit[nr][nc] = true;
                q.offer(new Node(nr, nc, temp.cnt+1));
            }
        }

        StringBuilder sb = new StringBuilder();
        // 출력
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                sb.append(ans[r][c]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}