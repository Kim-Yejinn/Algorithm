
import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int[][] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        temp = new int[10][10];
        arr = new int[10][10];

        int ans = Integer.MAX_VALUE;
        // 입력
        for(int i=0; i<10; i++){
            String str = sc.next();

            for(int j=0; j<10; j++){
                char t = str.charAt(j);
                if(t == 'O'){
                    arr[i][j] = temp[i][j] = 1;
                }
            }
        }

        // 첫째줄 경우의 수
        s: for(int i=0; i<1024; i++){
            init();

            String str = String.format("%010d",Integer.parseInt(Integer.toBinaryString(i)));



            int cnt = 0;
            // 첫줄
            for(int c=0; c<10; c++){
                int t = str.charAt(c)-'0';

                if(t == 1){
                    cnt++;
                    temp[0][c] ^=1;
                    if(c>0){
                        temp[0][c-1] ^=1;
                    }
                    if(c<9){
                        temp[0][c+1] ^=1;
                    }
                    temp[1][c] ^=1;
                }

            }
            // 두번째줄부터
            for(int r= 1; r<10; r++){
                for(int c=0; c<10; c++){
                    if(temp[r-1][c] == 1){
                        cnt++;
                        temp[r][c]^=1;
                        temp[r-1][c] ^=1;
                        if(c>0){
                            temp[r][c-1] ^=1;
                        }
                        if(c<9){
                            temp[r][c+1] ^=1;
                        }
                        if(r<9){
                            temp[r+1][c] ^=1;
                        }
                    }
                }
            }


            // 막줄일때 확인
            for(int j=0; j<10; j++){
                if(temp[9][j]==1){
                    continue s;
                }
            }

            if(ans > cnt){
                ans = cnt;
            }
        }
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }

    static void init(){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                temp[i][j] = arr[i][j];
            }
        }
    }
}
