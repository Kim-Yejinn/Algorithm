package Gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576 {

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
		// 전체 돌면서 날짜를 배열에 넣는다.
		// 토마토가 여러개여도
		// 큐를 사용할꺼기 때문에 넣어주면 순서대로 동시에 진행될것

		// 전체 날짜가 1일이다 = 0을 출력
		// 전체에서 가장 큰 값을 출력
		// 만약 0이 존재한다면 전체 못익으니 -1 출력

		Scanner sc = new Scanner(System.in);
		Queue<Node> q = new LinkedList<>();
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] arr = new int[M][N];
		int[][] visit = new int[M][N];

		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				arr[r][c] = sc.nextInt();
				if (arr[r][c] == 1) {
					q.offer(new Node(r, c));
					visit[r][c] = 1;
				}
			}
		}

		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		while (!q.isEmpty()) {
			Node temp = q.poll();

			int r = temp.r;
			int c = temp.c;

			for (int i = 0; i < 4; i++) {
				if (r + dr[i] < 0 || r + dr[i] >= M || c + dc[i] < 0 || c + dc[i] >= N) {
					continue;
				}
				if (visit[r + dr[i]][c + dc[i]] == 1 || arr[r + dr[i]][c + dc[i]] != 0) {
					continue;
				}

				q.offer(new Node(r + dr[i], c + dc[i]));
				visit[r + dr[i]][c + dc[i]] = 1;
				arr[r + dr[i]][c + dc[i]] = arr[r][c] + 1;

			}
		}

		int max = 0;
		int flag = 0;
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (arr[r][c] > max) {
					max = arr[r][c];
				}
				if (arr[r][c] == 0) {
					flag = 1;
				}
			}
		}
		if (flag == 1) {
			System.out.println(-1);
		} else {
			if (max == 1) {
				System.out.println(0);
			} else {
				System.out.println(max - 1);
			}
		}
	}
}
