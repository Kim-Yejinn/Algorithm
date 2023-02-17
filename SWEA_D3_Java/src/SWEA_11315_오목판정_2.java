import java.util.Scanner;

public class SWEA_11315_오목판정_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();

			int[][] arr = new int[N + 8][N + 8];

			// 입력
			for (int r = 0; r < N; r++) {
				String input = sc.next();

				for (int c = 0; c < N; c++) {
					if (input.charAt(c) == 'o') {
						arr[r + 4][c + 4] = 1;
					}
				}
			}

			start: for (int r = 4; r < N + 4; r++) {

				for (int c = 4; c < N + 4; c++) {

					if (arr[r][c] == 1) {
						int check_row = 0;
						int check_col = 0;
						int check_cross1 = 0;
						int check_cross2 = 0;

						for (int t = 1; t < 5; t++) {
							check_row += arr[r][c + t];
							check_col += arr[r + t][c];
							check_cross1 += arr[r + t][c + t];
							check_cross2 += arr[r + t][c - t];
						}
						if (check_row == 4 || check_col == 4 || check_cross1 == 4 || check_cross2 == 4) {
							System.out.printf("#%d %s\n", i, "YES");
							break start;
						}
					}
				}

				if (r == N + 3) {
					System.out.printf("#%d %s\n", i, "NO");
				}

			}

		}
	}
}
