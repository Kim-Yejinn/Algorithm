import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1974_스도쿠검증 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		start: for (int i = 1; i <= T; i++) {
			int[][] arr = new int[9][9];
			int flag = 1;

			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			for (int r = 0; r < 9; r++) {
				int[] test = new int[10];
				for (int c = 0; c < 9; c++) {
					test[arr[r][c]] = 1;

				}
				if (Arrays.stream(test).sum() == 9) {
					flag = 0;
				} else {
					System.out.printf("#%d 0\n", i);
					continue start;
				}

			}

			for (int r = 0; r < 9; r++) {
				int[] test = new int[10];
				for (int c = 0; c < 9; c++) {
					test[arr[c][r]] = 1;

				}
				if (Arrays.stream(test).sum() == 9) {
					flag = 0;
				} else {
					System.out.printf("#%d 0\n", i);
					continue start;
				}

			}
			for (int k = 0; k < 3; k++) {
				for (int j = 0; j < 3; j++) {
					int[] test = new int[10];

					for (int r = 0; r < 3; r++) {
						for (int c = 0; c < 3; c++) {
							test[arr[r + 3 * k][c + j * 3]] = 1;
						}
					}
					if (Arrays.stream(test).sum() == 9) {
						flag = 0;
					} else {
						System.out.printf("#%d 0\n", i);
						continue start;
					}

				}
			}
			System.out.printf("#%d 1\n", i);

		}

	}
}
