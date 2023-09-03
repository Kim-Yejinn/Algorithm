

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int H;
    static int[][] arr;

    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();

        ans = Integer.MAX_VALUE;
        arr = new int[H+1][N+1];

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = 1;
            arr[a][b+1] = -1;
        }

        rec(0,1,1);
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }

    }

    public static boolean check(){
        for(int i=1; i<=N; i++){
            int st = i;
            for(int row = 1; row<=H; row++){
                if(arr[row][st] !=0){
                    st +=arr[row][st];
                }
            }
            if(st != i){
                return false;
            }
        }
        return true;
    }

    public static void print(){
        for(int r=1; r<=H; r++){
            System.out.println(Arrays.toString(arr[r]));
        }
        System.out.println();
    }

    public static void rec(int num, int str, int stc){

        // 만약 지금 답보다 클 경우
        if(num>=ans){
            return;
        }

        // 만약 사다리 게임 조작 완료될 경우
        if(check()) {
            if (ans > num) {
                ans = num;
            }
            return;
        }

        // 만약 3개 이상일 경우
        if(num>=3){
            return;
        }
        
        // 하나 고르기

        for(int c=stc; c<N; c++){
            if(arr[str][c] == 0 && arr[str][c+1] == 0){
                arr[str][c] = 1;
                arr[str][c+1] = -1;
                rec(num+1,str, c);
                arr[str][c] = 0;
                arr[str][c+1] = 0;
            }
        }

        for(int r = str+1; r<=H; r++){
            for(int c=0; c<N; c++){
                if(arr[r][c] == 0 && arr[r][c+1] == 0){
                    arr[r][c] = 1;
                    arr[r][c+1] = -1;
                    rec(num+1,r, c);
                    arr[r][c] = 0;
                    arr[r][c+1] = 0;
                }
            }
        }
    }
}
