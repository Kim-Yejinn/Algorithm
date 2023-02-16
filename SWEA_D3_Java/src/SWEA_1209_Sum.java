import java.util.Scanner;

public class SWEA_1209_Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			int T = sc.nextInt();
			int result = 0;

			int[][] arr = new int[100][100];

			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			int cross1_temp = 0;
			int cross2_temp = 0;
			for (int r = 0; r < 100; r++) {
				int row_temp = 0;
				int col_temp = 0;
				for (int c = 0; c < 100; c++) {

					row_temp += arr[r][c];
					col_temp += arr[c][r];

					if (c == r) {
						cross1_temp += arr[r][c];
					}
					if (r == 99 - c) {
						cross2_temp += arr[r][c];
					}

				}
				if (result < row_temp) {
					result = row_temp;
				}
				if (result < col_temp) {
					result = col_temp;
				}

			}
			if (result < cross1_temp) {
				result = cross1_temp;
			}
			if (result < cross2_temp) {
				result = cross2_temp;
			}

			System.out.printf("#%d %d\n", T, result);

		}
	}
}
