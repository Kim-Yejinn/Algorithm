import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static class bomb{
        int r;
        int c;
        int time;

        bomb(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        int N = sc.nextInt();

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        char[][] arr = new char[R][C];
        int[][] isBomb = new int[R][C];

        Queue<bomb> bombList = new LinkedList<>();

        for(int r=0; r<R; r++){
            String str = sc.next();
            for(int c=0; c<C; c++){
                arr[r][c] = str.charAt(c);
                isBomb[r][c] = -1;
                if(arr[r][c] == 'O'){
                    bombList.add(new bomb(r,c,0));
                    isBomb[r][c] = 0;
                }
            }
        }

        for(int t=2; t<=N; t++){
            if(t%2 == 0){
                // 폭탄 설치
                for(int r=0; r<R; r++){
                    for(int c=0; c<C; c++){
                        if(arr[r][c]=='.'){
                            arr[r][c] = 'O';
                            bombList.add(new bomb(r,c,t));
                            isBomb[r][c] = t;
                        }
                    }
                }

            }else{
                // 폭탄 폭발
                while(!bombList.isEmpty()){
                    if(bombList.peek().time+3 == t){
                        // 시간이 된 경우
                        bomb temp = bombList.poll();

                        if(isBomb[temp.r][temp.c] == temp.time){
                            arr[temp.r][temp.c] = '.';
                            isBomb[temp.r][temp.c] = -1;

                            for(int i=0; i<4; i++){
                                int nr = temp.r+dr[i];
                                int nc = temp.c+dc[i];

                                if(nr<0||nc<0||nr>=R||nc>=C){
                                    continue;
                                }
                                arr[nr][nc] = '.';
                                if(isBomb[nr][nc]+3 !=t){
                                    isBomb[nr][nc] = -1;
                                }
                            }
                        }
                    }else{
                        break;
                    }
                }
            }
        }

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                System.out.print(arr[r][c]);
            }
            System.out.println();
        }


    }
}