import java.util.*;

public class Main {

    ///https://www.acmicpc.net/problem/16236
    public static class shark{
        int r;
        int c;
        int time;
        shark(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static class Node implements Comparable<Node>{
        int r;
        int c;
        Node(int r, int c){
            this.r=r;
            this.c=c;
        }

        @Override
        public int compareTo(Node o) {
            if(o.r == this.r){
                return this.c - o.c;
            }
            return this.r - o.r;
        }
    }
    static int[][] arr;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static int curR;
    static int curC;
    static int curSize;
    static int time;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N][N];

        int fish = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                arr[r][c] = sc.nextInt();

                if(arr[r][c]==9){
                    arr[r][c] = 0;
                    curR = r;
                    curC = c;
                    curSize = 2;
                }else if(arr[r][c]!=0){
                    fish++;
                }
            }
        }

        time = 0;
        cnt = 0;
        for(int i=0; i<fish; i++){
            move();
        }
        System.out.println(time);
    }

    public static void move(){
        int[] res = find();
        if(res[2] != -1){
            curR = res[0];
            curC = res[1];
            arr[curR][curC] = 0;
            time += res[2];
            cnt++;
            if(cnt == curSize){
                curSize++;
                cnt = 0;
            }
        }
    }

    public static int[] find(){
        List<Node> canEat = new ArrayList<>();
        int flag = Integer.MAX_VALUE;

        int[] ans = new int[3];
        boolean[][] visit = new boolean[N][N];

        Queue<shark> q = new LinkedList<>();
        q.offer(new shark(curR, curC, 0));
        visit[curR][curC] = true;

        while (!q.isEmpty()){
            shark temp = q.poll();

            if(temp.time > flag){
                continue;
            }
            if(arr[temp.r][temp.c] != 0 && arr[temp.r][temp.c] != curSize){
                flag = temp.time;
            }

            if(temp.time == flag){
                if(arr[temp.r][temp.c]!=0 && arr[temp.r][temp.c]!=curSize){
                    canEat.add(new Node(temp.r, temp.c));
                }
            }

            for(int i=0; i<4; i++){
                int nr = temp.r + dr[i];
                int nc = temp.c + dc[i];

                if(nr<0||nc<0||nr>=N||nc>=N){
                    continue;
                }
                if(visit[nr][nc]){
                    continue;
                }
                if(arr[nr][nc] > curSize){
                    continue;
                }
                visit[nr][nc] = true;
                q.offer(new shark(nr, nc, temp.time+1));
            }
        }


        Collections.sort(canEat);
        if(canEat.isEmpty()){
            ans[2] = -1;
        }else{
            ans[0] = canEat.get(0).r;
            ans[1] = canEat.get(0).c;
            ans[2] = flag;
        }
        return ans;
    }
}