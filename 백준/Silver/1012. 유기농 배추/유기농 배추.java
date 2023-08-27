
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int M = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();

			int[][] arr = new int[N][M];
			boolean[][] visit = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[b][a] = 1;
			}

			int cnt = 0;
			Queue<Node> q = new LinkedList<>();
			int[] dr = { 1, 0, -1, 0 };
			int[] dc = { 0, 1, 0, -1 };
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (!visit[r][c] && arr[r][c] == 1) {
						cnt++;
						q.offer(new Node(r, c));
						visit[r][c] = true;

						while (!q.isEmpty()) {
							Node temp = q.poll();
							for (int i = 0; i < 4; i++) {
								int nr = temp.r + dr[i];
								int nc = temp.c + dc[i];

								if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
									continue;
								}
								if (visit[nr][nc]) {
									continue;
								}
								if (arr[nr][nc] == 0) {
									continue;
								}
								visit[nr][nc] = true;

								q.offer(new Node(nr, nc));
							}
						}

					}
				}
			}

			System.out.println(cnt);

		}
	}
}
