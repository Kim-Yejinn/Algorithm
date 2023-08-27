import java.util.Scanner;

public class Main {
    // start : 14: 48
    // finish : 15 : 23
    // 35분
    
    // 풀이
    // 톱니 배열로 관리 + 인덱스로 관리
    // 인덱스 나머지 이용해서 계산
    
    // 주의
    // 1. 시계/반시계 헷갈리지 말기.

    // 개선 사항
    // 1. 점수를 비트연산자로 할수도 있을듯
    // 2. 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 전체 배열
        int[][] arr = new int[5][8];

        // 12시 방향부터 주어짐
        // 0 : N극, 1 : s극
        for(int r= 1; r<5; r++){
            String str = sc.next();
            for(int c=0; c<8; c++){
                arr[r][c]=str.charAt(c)-'0';
            }
        }
        
        // 인덱스 배열
        int[][] idx = new int[5][2];

        for(int i=1; i<5; i++){
            idx[i][0] = 6; // 왼쪽 인덱스
            idx[i][1] = 2; // 오른쪽 인덱스
        }

        int K = sc.nextInt();

        for(int i=0; i<K; i++){
            // 톱니 번호
            int t = sc.nextInt();
            // 방향 1: 시계 -1 : 반시계
            int dir = sc.nextInt();
            int[] check = new int[5];

            // 큰 쪽
            check[t] = -dir;
            for(int r=1; r<4; r++){
                int nr = t+r;

                if(nr>=5){
                    break;
                }

                if(arr[nr-1][idx[nr-1][1]] != arr[nr][idx[nr][0]]){
                    check[nr] = -check[nr-1];
                }else{
                    break;
                }
            }


            // 작은쪽
            for(int r=1; r<4; r++){
                int nr = t-r;
                if(nr<1){
                    break;
                }

                if(arr[nr+1][idx[nr+1][0]] != arr[nr][idx[nr][1]]){
                    check[nr] = -check[nr+1];
                }else{
                    break;
                }
            }

            // 반영
            for(int j=1; j<5; j++){
                idx[j][0] = (idx[j][0] + check[j] + 8) % 8;
                idx[j][1] = (idx[j][1] + check[j] + 8) % 8;
            }


        }

        // 점수
        int ans = 0;
        int[] score = {0, 1, 2, 4, 8};
        for(int i=1; i<5; i++) {
            int tw = (idx[i][1] + 6) % 8;
            ans += score[i] * arr[i][tw];
        }
        System.out.println(ans);

    }
}
