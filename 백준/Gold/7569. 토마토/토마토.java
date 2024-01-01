import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 토마토토마토
	// bfs

	static int M, N, H;
	static int[][][] arr;

	public static class Node {

		int h;
		int r;
		int c;
		int day;

		public Node(int h, int r, int c, int day) {
			super();
			this.h = h;
			this.r = r;
			this.c = c;
			this.day = day;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();

		int[][][] visit = new int[H][N][M];
		Queue<Node> q = new LinkedList<>();

		arr = new int[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					arr[h][r][c] = sc.nextInt();
					if (arr[h][r][c] == 1) {
						q.offer(new Node(h, r, c, 1));
						visit[h][r][c] = 1;
					}
				}
			}
		}

		int[] dr = { 1, 0, -1, 0, 0, 0 };
		int[] dc = { 0, 1, 0, -1, 0, 0 };
		int[] dh = { 0, 0, 0, 0, 1, -1 };

		while (!q.isEmpty()) {
			Node temp = q.poll();

			int h = temp.h;
			int r = temp.r;
			int c = temp.c;
			int day = temp.day;
			// 돌면서 토마토 익게 만든다..
			for (int i = 0; i < 6; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				int nh = h + dh[i];

				if (nr < 0 || nc < 0 || nh < 0 || nr > N - 1 || nc > M - 1 || nh > H - 1) {
					continue;
				}
				if (arr[nh][nr][nc] != 0 || visit[nh][nr][nc] == 1) {
					continue;
				}

				arr[nh][nr][nc] = day;
				q.offer(new Node(nh, nr, nc, day + 1));
				visit[nh][nr][nc] = 1;
			}
		}
		int max = 0;
		int flag = 0;
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (arr[h][r][c] > max) {
						max = arr[h][r][c];
					}
					if (arr[h][r][c] == 0) {
						flag = 1;
					}
				}
			}
		}
		if (flag == 1) {
			System.out.println(-1);
		} else {
			if (max == 1) {
				System.out.println(0);
			} else {
				System.out.println(max);
			}
		}

	}
}