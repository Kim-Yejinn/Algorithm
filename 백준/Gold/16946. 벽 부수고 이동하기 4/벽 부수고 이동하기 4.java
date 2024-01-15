import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node{
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

        int[][] arr = new int[N][M];
        int[][] num = new int[N][M];
        int[][] ans = new int[N][M];
        Map<Integer, Integer> map = new HashMap<>();

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        for(int r=0; r<N;r++){
            String str = br.readLine();
            for(int c=0; c<M; c++){
                arr[r][c] = str.charAt(c)-'0';
            }
        }

        boolean[][] visit = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();

        int idx = 1;

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(arr[r][c] == 0 && !visit[r][c]){
                    int cnt = 1;
                    q.offer(new Node(r, c));
                    visit[r][c] = true;
                    num[r][c] = idx;

                    while (!q.isEmpty()){
                        Node temp = q.poll();

                        for(int i=0; i<4; i++){
                            int nr = temp.r +dr[i];
                            int nc = temp.c +dc[i];

                            if(nr<0||nc<0||nr>=N||nc>=M){
                                continue;
                            }
                            if(arr[nr][nc] == 1){
                                continue;
                            }
                            if(visit[nr][nc]){
                                continue;
                            }
                            num[nr][nc] = idx;
                            cnt++;
                            q.offer(new Node(nr, nc));
                            visit[nr][nc] = true;
                        }
                    }
                    map.put(idx, cnt);
                    idx++;
                }
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(arr[r][c] == 1){
                    int sum = 1;
                    int[] temp = new int[4];

                    for(int i=0; i<4; i++){
                        int nr = r+dr[i];
                        int nc = c+dc[i];

                        if(nr<0||nc<0||nr>=N||nc>=M){
                            continue;
                        }
                        if(arr[nr][nc] == 1){
                            continue;
                        }
                        boolean flag = false;
                        for(int j=0; j<i; j++){
                            if (temp[j] == num[nr][nc]) {
                                flag = true;
                                break;
                            }
                        }
                        if(!flag){
                            sum += map.get(num[nr][nc]);
                            temp[i] = num[nr][nc];
                        }
                    }
                    ans[r][c] = sum%10;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                sb.append(ans[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}