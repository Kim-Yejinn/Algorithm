import java.util.Scanner;

public class SWEA_1961_숫자배열회전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();

			int[][] input = new int[N][N];

			int[][] input_90 = new int[N][N];
			int[][] input_180 = new int[N][N];
			int[][] input_270 = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					input[r][c] = sc.nextInt();

				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					input_90[c][N - r - 1] = input[r][c];
					input_180[N - r - 1][N - c - 1] = input[r][c];
					input_270[N - c - 1][r] = input[r][c];
				}
			}

			System.out.println("#" + i);

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					System.out.print(input_90[r][c]);
				}
				System.out.print(" ");
				for (int c = 0; c < N; c++) {
					System.out.print(input_180[r][c]);
				}
				System.out.print(" ");
				for (int c = 0; c < N; c++) {
					System.out.print(input_270[r][c]);
				}
				System.out.println();
			}

		}

	}
}
