package Gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2573 {
	// bfs로 년도별 빙산 녹이기
	// bfs로 넓이 카운트 하면서
	// 년도별 개수 카운트..

	// 좌표값 저장 해야됨..
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
		int M = sc.nextInt();

		int[][] arr = new int[N][M];

		Queue<Node> q = new LinkedList<>();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		int time = 0;

		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		while (true) {
			int[][] visit = new int[N][M];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (arr[r][c] == 0 || visit[r][c] == 1) {
						continue;
					}

					q.offer(new Node(r, c));
					visit[r][c] = 1;

					while (!q.isEmpty()) {

						Node temp = q.poll();
						int R = temp.r;
						int C = temp.c;

						for (int i = 0; i < 4; i++) {
							int nr = R + dr[i];
							int nc = C + dc[i];

							if (nr < 0 || nc < 0 || nr > N - 1 || nc > M - 1)
								continue;
							if (arr[nr][nc] != 0 || visit[nr][nc] == 1)
								continue;

							arr[R][C]--;
							if (arr[R][C] < 0) {
								arr[R][C] = 0;
							}
							visit[R][C] = 1;

						}

					}

				}
			}

			visit = new int[N][M];
			int cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (arr[r][c] == 0 || visit[r][c] == 1) {
						continue;
					}

					q.offer(new Node(r, c));
					visit[r][c] = 1;

					while (!q.isEmpty()) {

						Node temp = q.poll();
						int R = temp.r;
						int C = temp.c;

						for (int i = 0; i < 4; i++) {
							int nr = R + dr[i];
							int nc = C + dc[i];

							if (nr < 0 || nc < 0 || nr > N - 1 || nc > M - 1)
								continue;
							if (arr[nr][nc] == 0 || visit[nr][nc] == 1)
								continue;
							q.offer(new Node(nr, nc));
							visit[nr][nc] = 1;

						}

					}
					cnt++;
				}
			}

			if (cnt >= 2) {
				System.out.println(++time);
				break;
			}
			if (cnt == 0) {
				System.out.println(0);
				break;
			}
			time++;
		}

	}

}
