import java.util.Scanner;

public class SWEA_1979_어디에단어가들어갈수있을까 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();
			int K = sc.nextInt();

			int total_cnt = 0;
			int temp_cnt = 0;

			int[][] arr = new int[N + 1][N + 1];

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					arr[j][k] = sc.nextInt();
				}
			}

			for (int j = 0; j < N; j++) {

				for (int k = 0; k < N + 1; k++) {
					if (arr[j][k] == 1)
						temp_cnt++;
					else {
						if (temp_cnt == K) {
							total_cnt++;
						}
						temp_cnt = 0;
					}

				}
			}

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N + 1; k++) {
					if (arr[k][j] == 1)
						temp_cnt++;
					else {
						if (temp_cnt == K) {
							total_cnt++;
						}
						temp_cnt = 0;
					}

				}

			}

			System.out.printf("#%d %d\n", i, total_cnt);
		}

	}
}
