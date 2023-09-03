
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    // 시계 방향
    static int[] dr = {0, 1, 0,-1};
    static int[] dc = {1, 0, -1, 0};

    static int N;
    static int M;
    static int ans;

    static int[][] arr;
    static List<Node> list;
    public static class Node{
        int r;
        int c;
        int num;

        Node(int r, int c, int num){
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        ans = Integer.MAX_VALUE;
        arr = new int[N][M];
        list = new ArrayList<>();

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                arr[r][c] = sc.nextInt();
                if(arr[r][c]>0 && arr[r][c]<6){
                    list.add(new Node(r,c,arr[r][c]));
                }
            }
        }

        rec(0 );

        System.out.println(ans);
    }
    public static void check(int r, int c, int dir){
        dir = dir % 4;
        for(int i=1; i<=8; i++){
            int nr = r+dr[dir]*i;
            int nc = c+dc[dir]*i;

            if(nr<0||nc<0||nr>=N||nc>=M){
                break;
            }
            if(arr[nr][nc] == 6){
                break;
            }
            if(arr[nr][nc]!=0){
                continue;
            }
            arr[nr][nc] = -1;
        }
    }

    public static void count(){
        int sum = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(arr[r][c]==0){
                    sum++;
                }
            }
        }

        if(sum < ans){
            ans = sum;
        }
    }
    public static void rec(int num){
        if(num == list.size()){
            // 다 골랐을 경우
            count();
            return;
        }

        int[][] temp = new int[N][M];

        // num 번째 cctv

        int cr = list.get(num).r;
        int cc = list.get(num).c;

        // 방향 별로 확인
        for(int i=0; i<4; i++){
            // 현재 상태 기록
            for(int r=0; r<N; r++){
                for(int c=0; c<M; c++){
                    temp[r][c]=arr[r][c];
                }
            }

            //cctv 번호에 따라서
            int n = list.get(num).num;

            if(n == 1){
                check(cr, cc, 0+i);
            }else if(n==2){
                check(cr, cc, 0+i);
                check(cr, cc, 2+i);
            }else if(n==3){
                check(cr, cc, 0+i);
                check(cr, cc, 3+i);
            }else if(n==4){
                check(cr, cc, 0+i);
                check(cr, cc, 2+i);
                check(cr, cc, 3+i);
            }else if(n==5){
                check(cr, cc, 0+i);
                check(cr, cc, 1+i);
                check(cr, cc, 2+i);
                check(cr, cc, 3+i);
            }

            //다음 것으로
            rec(num+1);

            // 다시 돌려 놓음
            for(int r=0; r<N; r++){
                for(int c=0; c<M; c++){
                    arr[r][c]=temp[r][c];
                }
            }
        }
    }
}
