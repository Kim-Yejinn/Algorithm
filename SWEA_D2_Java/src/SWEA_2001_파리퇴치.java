import java.util.Scanner;

public class SWEA_2001_파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();
			int M = sc.nextInt();
			int sum = 0;

			int[][] arr = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			int temp = 0;
			for (int r = 0; r <= N - M; r++) {
				for (int c = 0; c <= N - M; c++) {
					for (int t = 0; t < M; t++) {
						for (int j = 0; j < M; j++) {
							temp += arr[r + t][c + j];
						}
					}
					if (sum < temp)
						sum = temp;
					temp = 0;
				}
			}
			System.out.printf("#%d %d\n", i, sum);
		}

	}
}
