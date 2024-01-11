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
        Node(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        char[][] arr = new char[N][M];

        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=0; c<M; c++){
                arr[r][c] = str.charAt(c);
            }
        }

        int max = 0;

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(arr[r][c] == 'L'){
                    boolean[][] visit = new boolean[N][M];
                    Queue<Node> q = new LinkedList<>();

                    q.offer(new Node(r,c,0));
                    visit[r][c] = true;

                    while (!q.isEmpty()){
                        Node temp = q.poll();

                        if(max < temp.cnt){
                            max = temp.cnt;
                        }

                        for(int i=0; i<4; i++){
                            int nr = temp.r + dr[i];
                            int nc = temp.c + dc[i];

                            if(nr<0||nc<0||nr>=N||nc>=M){
                                continue;
                            }
                            if(visit[nr][nc]){
                                continue;
                            }
                            if(arr[nr][nc] == 'W'){
                                continue;
                            }

                            visit[nr][nc] = true;
                            q.offer(new Node(nr, nc,temp.cnt+1));

                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}