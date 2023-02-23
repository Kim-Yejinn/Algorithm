import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ddd {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < N; c++) {
                board[r][c] = str.charAt(c);
            }
        }
        int min = 100;
        
        int cnt = 0;
        for (int r = 0; r < N - 7; r++) {
            for (int c = 0; c < M - 7; c++) {
                cnt = 0;
                // 첫 시작이 B이도록
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (i % 2 == 0) {// 0,2,4,6,8행일 때
                            if (j % 2 == 0 && board[r + i][c + j] != 'B') { // 짝수열 B여야 함.
                                cnt++;
                                System.out.println("행 : " + (r + i) + "열 : " + (c + j) + "에서 더해짐1");
                            } else if ( j % 2 != 0 && board[r + i][c + j] != 'W') {
                                cnt++; // 홀수열은 W여야 함.
                                System.out.println("행 : " + (r + i) + "열 : " + (c + j) + "에서 더해짐2");
                            }
                        } else { // 1,3,5,7행
                            if (j% 2 == 0 && board[r + i][c + j] != 'W') { // 짝수열
                                cnt++;
                                System.out.println("행 : " + (r + i) + "열 : " + (c + j) + "에서 더해짐3");
                            } else if (j % 2 != 0 && board[r + i][c + j] != 'B') {
                                cnt++;
                                System.out.println("행 : " + (r + i) + "열 : " + (c + j) + "에서 더해짐4");
                            }
                        }
                    }
                }
                System.out.println("첫시작 B일 때 : ");
                System.out.println("r : " + r + " c : " + c + " cnt : " + cnt);
                if (cnt < min) {
                    min = cnt;
                }
                cnt = 0;
                // 첫 시작이 W이도록
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (i % 2 == 0) {// 0,2,4,6,8행일 때
                            if (j % 2 == 0 && board[r + i][c + j] != 'W') { // 짝수열 W여야 함.
                                cnt++;
                                System.out.println("행 : " + (r + i) + "열 : " + (c + j) + "에서 더해짐");
                            } else if ( j % 2 != 0 && board[r + i][c + j] != 'B') {
                                cnt++; // 홀수열은 B여야 함.
                                System.out.println("행 : " + (r + i) + "열 : " + (c + j) + "에서 더해짐");
                            }
                        } else { // 1,3,5,7행
                            if (j % 2 == 0 && board[r + i][c + j] != 'B') { // 짝수열
                                cnt++;
                                System.out.println("행 : " + (r + i) + "열 : " + (c + j) + "에서 더해짐");
                            } else if ( j % 2 != 0 && board[r + i][c + j] != 'W') {
                                cnt++;
                                System.out.println("행 : " + (r + i) + "열 : " + (c + j) + "에서 더해짐");
                            }
                        }
                    }
                }
                System.out.println("첫시작 W일 때 : ");
                System.out.println("r : " + r + " c : " + c + " cnt : " + cnt);
                if (cnt < min) {
                    min = cnt;
                }



            }

        }
        System.out.println(min);
    }

}