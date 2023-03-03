import java.util.Scanner;

public class SWEA_4613_러시아국기같은깃발 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] arr = new int[N][M];

			for (int r = 0; r < N; r++) {
				String temp = sc.next();
				for (int c = 0; c < M; c++) {
					arr[r][c] = temp.charAt(c);
				}
			}

			int result = N * M;
			for (int i = 1; i <= N - 2; i++) {
				for (int j = 1; j <= N - 1 - i; j++) {

					int cnt = 0;
					for (int q = 0; q < i; q++) {
						for (int w = 0; w < M; w++) {
							if (arr[q][w] != 'W') {
								cnt++;
							}
						}
					}
					for (int q = i; q < i + j; q++) {
						for (int w = 0; w < M; w++) {
							if (arr[q][w] != 'B') {
								cnt++;
							}
						}
					}
					for (int q = i + j; q < N; q++) {
						for (int w = 0; w < M; w++) {
							if (arr[q][w] != 'R') {
								cnt++;
							}
						}
					}
					if (cnt < result) {
						result = cnt;
					}

				}
			}
			System.out.printf("#%d %d\n", tc, result);

		}
	}
}
