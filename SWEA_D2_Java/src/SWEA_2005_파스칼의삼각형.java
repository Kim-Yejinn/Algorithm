import java.util.Scanner;

public class SWEA_2005_파스칼의삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();

			int[][] arr = new int[N][];
			for (int j = 1; j <= N; j++) {

				arr[j - 1] = new int[j];
				arr[j - 1][0] = 1;
				arr[j - 1][j - 1] = 1;
				if (j > 2) {
					for (int k = 1; k < j - 1; k++) {
						arr[j - 1][k] = arr[j - 2][k - 1] + arr[j - 2][k];

					}

				}

			}

			System.out.printf("#%d\n", i);

			for (int j = 0; j < N; j++) {
				for (int k = 0; k <= j; k++) {
					System.out.print(arr[j][k] + " ");
				}
				System.out.println();

			}

		}

	}
}
