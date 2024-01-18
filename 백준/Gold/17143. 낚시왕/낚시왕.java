import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int r;
        int c;
        int s;
        int d;
        int z;
        Node(int r, int c, int s, int d, int z){
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 1, -1};
    static int[][] arr;
    static boolean[] check;
    static Node[] shark;

    static int R;
    static int C;
    static int M;
    static int ans;
    static int divR;
    static int divC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        divR = 2*(R-1);
        divC = 2*(C-1);

        ans = 0;
        arr = new int[R][C];
        check = new boolean[M+1];
        shark = new Node[M+1];

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            shark[i] = new Node(r-1, c-1, s, d, z);
            arr[r-1][c-1] = i;
        }

        for(int i=0; i<C; i++){
            findShark(i);
            moveAll();
        }
        System.out.println(ans);

    }
    public static void findShark(int idx){
        for(int i=0; i<R; i++){
            if(arr[i][idx] != 0){
                die(i, idx);
                break;
            }
        }
    }
    public static void die(int r, int c){
        int idx = arr[r][c];
        arr[r][c] = 0;
        check[idx] = true;
        ans += shark[idx].z;
    }
    public static void moveAll(){
        for(int i=1; i<=M; i++){
            if(!check[i]){
                moveOne(i);
            }
        }
    }
    public static int nextR(int idx, int r){
        int curR = r;
        if(curR >= R){
            curR = (2*(R-1)) - curR;
            shark[idx].d = changeDir(shark[idx].d);
        }
        return curR;
    }
    public static int nextC(int idx, int c){
        int curC = c;
        if(curC >= C){
            curC = (2*(C-1)) - curC;
            shark[idx].d = changeDir(shark[idx].d);
        }
        return curC;
    }
    public static int changeDir(int num){
        if(num==1){
            return 2;
        }
        if(num==2){
            return 1;
        }
        if(num==3){
            return 4;
        }
        if(num==4){
            return 3;
        }
        return 0;
    }
    public static void moveOne(int idx){
        Node temp = shark[idx];

        int nr = (temp.r + temp.s * dr[temp.d] + (1000/divR+1)*divR ) % divR;
        int nc = (temp.c + temp.s * dc[temp.d] + (1000/divC+1)*divC ) % divC;

        nr = nextR(idx, nr);
        nc = nextC(idx, nc);

        // 이미 자리를 잡고 있는 이전 인덱스 상어가 있을 수도 있음.!!
        // 이렇게 안할거면 새로 배열 만들어서 복사하면 될듯 -> 이게 실수가 더 작을듯
        if(arr[temp.r][temp.c] == idx){
            arr[temp.r][temp.c] = 0;
        }

        if(arr[nr][nc] != 0){
            if(arr[nr][nc] < idx){
                // 상어 잡아 먹기
                Node old = shark[arr[nr][nc]];

                if(old.z < temp.z){
                    // 예전 상어 먹기
                    check[arr[nr][nc]] = true;
                    arr[nr][nc] = idx;

                    shark[idx].r = nr;
                    shark[idx].c = nc;
                }else{
                    // 지금 상어 먹기
                    check[idx] = true;
                }
            }else{
                arr[nr][nc] = idx;
                shark[idx].r = nr;
                shark[idx].c = nc;
            }
        }else{
            arr[nr][nc] = idx;
            shark[idx].r = nr;
            shark[idx].c = nc;
        }

    }

}