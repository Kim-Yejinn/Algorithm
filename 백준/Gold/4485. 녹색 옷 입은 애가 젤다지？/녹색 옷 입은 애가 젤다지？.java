
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int tc = 0;
		while (true) {
			tc++;
			int N = sc.nextInt();
			if (N == 0) {
				break;
			}

			int[][] map = new int[N][N];
			int[][] ans = new int[N][N];
			boolean[][] visit = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
					ans[r][c] = INF;
				}
			}

			ans[0][0] = map[0][0];

			for (int j = 0; j < N * N; j++) {

				int min = INF;
				int idx_r = -1;
				int idx_c = -1;

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (!visit[r][c] && min > ans[r][c]) {
							min = ans[r][c];
							idx_r = r;
							idx_c = c;
						}
					}
				}
				if (idx_r == -1) {
					continue;
				}

				visit[idx_r][idx_c] = true;

				for (int i = 0; i < 4; i++) {
					int nr = idx_r + dr[i];
					int nc = idx_c + dc[i];

					if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
						continue;
					}
					if (visit[nr][nc]) {
						continue;
					}

					if (ans[nr][nc] > ans[idx_r][idx_c] + map[nr][nc]) {
						ans[nr][nc] = ans[idx_r][idx_c] + map[nr][nc];
					}
				}
			}
			System.out.printf("Problem %d: %d\n", tc, ans[N - 1][N - 1]);
		}
	}
}
