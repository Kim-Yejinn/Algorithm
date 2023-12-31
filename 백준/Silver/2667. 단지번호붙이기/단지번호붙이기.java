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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] arr = new int[N][N];
        boolean[][] visit = new boolean[N][N];

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        ArrayList<Integer> list = new ArrayList<>();

        for(int r = 0; r<N; r++){
            String str = sc.next();
            for(int c=0; c<N; c++){
                arr[r][c] = str.charAt(c)-'0';
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(arr[r][c]==1){
                    if(visit[r][c]){
                        continue;
                    }
                    int cnt = 0;
                    Queue<Node> q = new LinkedList<>();
                    q.offer(new Node(r,c));
                    visit[r][c] = true;

                    while (!q.isEmpty()){
                        Node temp = q.poll();
                        cnt++;
                        for(int i=0; i<4; i++){
                            int nr = temp.r+dr[i];
                            int nc = temp.c+dc[i];

                            if(nr<0||nc<0||nr>=N||nc>=N){
                                continue;
                            }
                            if(visit[nr][nc]){
                                continue;
                            }
                            if(arr[nr][nc]==0){
                                continue;
                            }

                            q.offer(new Node(nr, nc));
                            visit[nr][nc] = true;

                        }
                    }
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}