package Silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2468 {
	public static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] arr = new int[N][N];

		int maxrain = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				arr[r][c] = sc.nextInt();
				if (arr[r][c] > maxrain) {
					maxrain = arr[r][c];
				}
			}
		}

		Queue<Node> q = new LinkedList<>();
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int max = 0;
		for (int j = 0; j < maxrain; j++) {
			int[][] cntarr = new int[N][N];
			int[][] visit = new int[N][N];
			int cnt = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (arr[r][c] > j) {
						cntarr[r][c] = 1;
					}
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (cntarr[r][c] == 0)
						continue;
					if (visit[r][c] == 1)
						continue;

					q.offer(new Node(r, c));
					visit[r][c] = 1;

					while (!q.isEmpty()) {
						Node temp = q.poll();
						int R = temp.r;
						int C = temp.c;

						for (int i = 0; i < 4; i++) {
							int nr = R + dr[i];
							int nc = C + dc[i];

							if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1)
								continue;
							if (cntarr[nr][nc] == 0 || visit[nr][nc] == 1)
								continue;

							q.offer(new Node(nr, nc));
							visit[nr][nc] = 1;
						}
					}
					cnt++;
				}
			}

			if (max < cnt) {
				max = cnt;
			}

		}
		System.out.println(max);

	}
}
