import java.util.Scanner;

public class BOJ_2615 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[29][29];

		for (int r = 5; r < 24; r++) {
			for (int c = 5; c < 24; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		int flag = 0;
		for (int r = 5; r < 24; r++) {
			for (int c = 5; c < 24; c++) {
				int check_row_b = 0;
				int check_col_b = 0;
				int check_cross1_b = 0;
				int check_cross2_b = 0;

				int check_row_w = 0;
				int check_col_w = 0;
				int check_cross1_w = 0;
				int check_cross2_w = 0;

				if (arr[r][c] == 1 || arr[r][c] == 2) {
					int temp = arr[r][c];

					for (int d = 1; d <= 5; d++) {

						if (arr[r][c - 1] != temp) {
							if (arr[r][c + d] == 1 && temp == 1) {
								check_row_b++;
							} else if (arr[r][c + d] != 1 && check_row_b != 4) {
								check_row_b = -3;
							}
							if (arr[r][c + d] == 2 && temp == 2) {
								check_row_w++;
							} else if (arr[r][c + d] != 2 && check_row_w != 4) {
								check_row_w = -3;
							}
						}
						if (arr[r - 1][c] != temp) {
							if (arr[r + d][c] == 1 && temp == 1) {
								check_col_b++;
							} else if (arr[r + d][c] != 1 && check_col_b != 4) {
								check_col_b = -3;
							}

							if (arr[r + d][c] == 2 && temp == 2) {
								check_col_w++;
							} else if (arr[r + d][c] != 2 && check_col_w != 4) {
								check_col_w = -3;

							}
						}

						if (arr[r - 1][c - 1] != temp) {
							if (arr[r + d][c + d] == 1 && temp == 1) {
								check_cross1_b++;
							} else if (arr[r + d][c + d] != 1 && check_cross1_b != 4) {
								check_cross1_b = -3;
							}

							if (arr[r + d][c + d] == 2 && temp == 2) {
								check_cross1_w++;
							} else if (arr[r + d][c + d] != 2 && check_cross1_w != 4) {
								check_cross1_w = -3;

							}
						}

						if (arr[r - 1][c + 1] != temp) {
							if (arr[r + d][c - d] == 1 && temp == 1) {
								check_cross2_b++;
							} else if (arr[r + d][c - d] != 1 && check_cross2_b != 4) {
								check_cross2_b = -3;
							}

							if (arr[r + d][c - d] == 2 && temp == 2) {
								check_cross2_w++;
							} else if (arr[r + d][c - d] != 2 && check_cross2_w != 4) {
								check_cross2_w = -3;

							}
						}
					}
				}
				if (check_row_b == 4 || check_col_b == 4 || check_cross1_b == 4) {
					System.out.printf("%d\n%d %d", 1, r - 4, c - 4);
					flag = 1;

				}
				if (check_cross2_b == 4) {
					System.out.printf("%d\n%d %d", 1, r, c - 8);
					flag = 1;

				}

				if (check_row_w == 4 || check_col_w == 4 || check_cross1_w == 4) {
					System.out.printf("%d\n%d %d", 2, r - 4, c - 4);
					flag = 1;

				}

				if (check_cross2_w == 4) {
					System.out.printf("%d\n%d %d", 2, r, c - 8);
					flag = 1;

				}

			}
		}
		if (flag == 0) {
			System.out.println(0);
		}

	}

}
