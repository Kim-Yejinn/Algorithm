
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int A;
	static int B;

	static int[][] arr;
	static boolean[][] visit;
	static int cnt;

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

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

		N = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();

		arr = new int[N][N];
		cnt = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		rec();

		System.out.println(cnt);
	}

	public static void rec() {
		visit = new boolean[N][N];
		boolean flag = false;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (visit[r][c]) {
					continue;
				}
				Queue<Node> q = new LinkedList<>();
				Queue<Node> list = new LinkedList<>();

				q.offer(new Node(r, c));
				visit[r][c] = true;
				boolean flag2 = false;
				int sum = 0;
				int count = 0;
				while (!q.isEmpty()) {
					Node temp = q.poll();
					count++;
					sum += arr[temp.r][temp.c];
					list.offer(new Node(temp.r, temp.c));

					for (int i = 0; i < 4; i++) {
						int nr = temp.r + dr[i];
						int nc = temp.c + dc[i];

						if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
							continue;
						}
						if (visit[nr][nc]) {
							continue;
						}
						int diff = Math.abs(arr[temp.r][temp.c] - arr[nr][nc]);
						if (diff < A || diff > B) {
							continue;
						}

						visit[nr][nc] = true;
						flag = true;
						flag2 = true;
						q.offer(new Node(nr, nc));
					}
				}

				if (!flag2) {
					continue;
				}
				int avg = sum / count;

				if (list.size() != 0) {
					list.offer(new Node(r, c));
				}

				while (!list.isEmpty()) {
					Node temp = list.poll();
					arr[temp.r][temp.c] = avg;
				}

			} ///
		}

		if (flag) {
			cnt++;
			rec();
		} else {
			return;
		}
	}
}
