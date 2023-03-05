package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_4179 {
	public static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");
		int R = temp[0].charAt(0) - '0';
		int C = temp[1].charAt(0) - '0';

		char[][] arr = new char[R][C];
		int[][] visit = new int[R][C];

		Queue<Node> qj = new LinkedList<>();
		Queue<Node> qf = new LinkedList<>();

		for (int r = 0; r < R; r++) {
			arr[r] = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if (arr[r][c] == 'J') {
					qj.offer(new Node(r, c));
					visit[r][c] = 1;
				}
				if (arr[r][c] == 'F') {
					qf.offer(new Node(r, c));
				}
			}
		}

		int time = 1;

		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		while (true) {
			if (qj.isEmpty()) {
				System.out.println("IMPOSSIBLE");
				return;
			}
			int t = qf.size();
			for (int k = 0; k < t; k++) {
				Node tempf = qf.poll();
				int rf = tempf.r;
				int cf = tempf.c;
				for (int i = 0; i < 4; i++) {
					int nr = rf + dr[i];
					int nc = cf + dc[i];
					if (nr < 0 || nc < 0 || nr > R - 1 || nc > C - 1)
						continue;
					if (arr[nr][nc] == 'F' || arr[nr][nc] == '#')
						continue;
					qf.offer(new Node(nr, nc));
					arr[nr][nc] = 'F';
				}

			}

			int w = qj.size();
			for (int k = 0; k < w; k++) {
				Node tempj = qj.poll();
				int rj = tempj.r;
				int cj = tempj.r;

				for (int i = 0; i < 4; i++) {
					int nr = rj + dr[i];
					int nc = cj + dc[i];

					if (nr < 0 || nc < 0 || nr > R - 1 || nc > C - 1)
						continue;
					if (arr[nr][nc] == '#' || visit[nr][nc] == 1)
						continue;
					if (arr[nr][nc] == 'F') {
						if (nr == 0 || nr == R - 1 || nc == 0 || nc == C - 1) {
							System.out.println(++time);
							return;
						} else {
							continue;
						}
					}
					if (nr == 0 || nr == R - 1 || nc == 0 || nc == C - 1) {
						System.out.println(++time);
						return;
					}
					qj.offer(new Node(nr, nc));

					arr[nr][nc] = 'J';
					visit[nr][nc] = 1;
				}
			}
			time++;
		}

	}
}
