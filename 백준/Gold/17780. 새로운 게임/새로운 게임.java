import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int r;
        int c;
        int dir;

        Node(int r, int c, int dis){
            this.r = r;
            this.c = c;
            this.dir = dis;
        }
        void reverse(){
            if(this.dir == 1){
                this.dir = 2;
            }else if(this.dir == 2){
                this.dir = 1;
            }else if(this.dir == 3){
                this.dir = 4;
            }else if(this.dir == 4){
                this.dir = 3;
            }
        }
    }

    static int[] dr = {0, 0, 0, -1, 1};
    static int[] dc = {0, 1, -1, 0, 0};

    static List<Integer>[][] list;
    static int[][] arr;
    static Node[] nodeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        list = new ArrayList[N][N];
        nodeList = new Node[K+1];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
                list[r][c] = new ArrayList<>();
            }
        }

        for(int i=1; i<=K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());

            Node temp = new Node(a, b, c);
            list[a][b].add(i);
            nodeList[i] = temp;
        }

        int ans = -1;
        int time = 0;
        while ((time++) <= 1000){
            if(ans != -1){
                break;
            }

            for(int i=1; i<=K; i++){
                Node temp = nodeList[i];
                if(list[temp.r][temp.c].get(0) != i){
                    continue;
                }

                int sr = temp.r;
                int sc = temp.c;

                int nr = temp.r + dr[temp.dir];
                int nc = temp.c + dc[temp.dir];

                if(nr<0 || nc<0 || nr>=N || nc>=N){
                    // 파란색
                    temp.reverse();
                    nr = temp.r + dr[temp.dir];
                    nc = temp.c + dc[temp.dir];
                    if(!(nr<0|| nc<0||nr>=N || nc>=N)) {
                        if (arr[nr][nc] == 0) {
                            // 흰색
                            for (int j = 0; j < list[sr][sc].size(); j++) {
                                int t = list[sr][sc].get(j);
                                list[nr][nc].add(t);
                                nodeList[t].r = nr;
                                nodeList[t].c = nc;
                            }
                            list[sr][sc] = new ArrayList<>();
                        } else if (arr[nr][nc] == 1) {
                            // 빨간색
                            for (int j = list[sr][sc].size() - 1; j >= 0; j--) {
                                int t = list[sr][sc].get(j);
                                list[nr][nc].add(t);
                                nodeList[t].r = nr;
                                nodeList[t].c = nc;
                            }
                            list[sr][sc] = new ArrayList<>();
                        }
                        if (list[nr][nc].size() >= 4) {
                            ans = time;
                        }
                    }
                }else{
                    if(arr[nr][nc] == 0){
                        // 흰색
                        for(int j=0; j<list[sr][sc].size(); j++){
                            int t = list[sr][sc].get(j);
                            list[nr][nc].add(t);
                            nodeList[t].r = nr;
                            nodeList[t].c = nc;
                        }
                        list[sr][sc] = new ArrayList<>();

                        if(list[nr][nc].size() >= 4){
                            ans = time;
                        }
                    }else if(arr[nr][nc] == 1){
                        // 빨간색
                        for(int j=list[sr][sc].size()-1; j>=0; j--){
                            int t = list[sr][sc].get(j);
                            list[nr][nc].add(t);
                            nodeList[t].r = nr;
                            nodeList[t].c = nc;
                        }
                        list[sr][sc] = new ArrayList<>();

                        if(list[nr][nc].size() >= 4){
                            ans = time;
                        }
                    }else{
                        // 파란색
                        temp.reverse();
                        nr = temp.r + dr[temp.dir];
                        nc = temp.c + dc[temp.dir];
                        if(!(nr<0|| nc<0||nr>=N || nc>=N)){
                            if(arr[nr][nc] == 0){
                                // 흰색
                                for(int j=0; j<list[sr][sc].size(); j++){
                                    int t = list[sr][sc].get(j);
                                    list[nr][nc].add(t);
                                    nodeList[t].r = nr;
                                    nodeList[t].c = nc;
                                }
                                list[sr][sc] = new ArrayList<>();
                            }else if(arr[nr][nc] == 1) {
                                // 빨간색
                                for (int j = list[sr][sc].size() - 1; j >= 0; j--) {
                                    int t = list[sr][sc].get(j);
                                    list[nr][nc].add(t);
                                    nodeList[t].r = nr;
                                    nodeList[t].c = nc;
                                }
                                list[sr][sc] = new ArrayList<>();
                            }

                            if(list[nr][nc].size() >= 4){
                                ans = time;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}