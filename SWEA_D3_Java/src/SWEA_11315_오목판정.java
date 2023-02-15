import java.util.Scanner;

public class SWEA_11315_오목판정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[][] cnt = new int[N + 8][N + 8];

			for (int j = 4; j < N + 4; j++) {
				String s = sc.next();

				for (int k = 0; k < N; k++) {
					char temp = s.charAt(k);
					if (temp == 'o') {
						cnt[j][k + 4]++;
					}
				}
			}

			int flag = 0;
			start: for (int r = 4; r < N + 4; r++) {
				for (int c = 4; c < N + 4; c++) {
					int check_row = 0;
					int check_col = 0;
					int check_cross1 = 0;
					int check_cross2 = 0;

					if (cnt[r][c] == 1) {
						for (int d = 1; d <= 4; d++) {
							if (cnt[r][c + d] == 1) {
								check_row++;
							}
							if (cnt[r + d][c] == 1) {
								check_col++;
							}
							if (cnt[r + d][c + d] == 1) {
								check_cross1++;
							}
							if (cnt[r + d][c - d] == 1) {
								check_cross2++;
							}
						}
					}
					if (check_row == 4 || check_col == 4 || check_cross1 == 4 || check_cross2 == 4) {
						System.out.printf("#%d %s\n", i, "YES");
						flag = 1;
						break start;
					}
				}
			}
			if (flag == 0) {
				System.out.printf("#%d %s\n", i, "NO");
			}

		}
	}
}