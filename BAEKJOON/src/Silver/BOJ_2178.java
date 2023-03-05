package Silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178 {
	public static class Node {
		int r;
		int c;
		int num;

		public Node(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] arr = new int[N][M];
		int[][] visit = new int[N][M];

		for (int r = 0; r < N; r++) {
			String temp = sc.next();
			for (int c = 0; c < M; c++) {
				arr[r][c] = temp.charAt(c) - '0';
			}
		}

		// 가장 작은 경로..
		// 큐를 써야된다..
		// 좌표 정보 가진 노드가 있어야 된다..
		Queue<Node> q = new LinkedList<>();

		// 우선 하나 넣어야 됨
		// 첫칸은 0,0
		// 몇번째 들어간 노드인가..1
		q.offer(new Node(0, 0, 1));
		visit[0][0] = 1;

		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			// 하나 빼자..
			Node temp = q.poll();

			int r = temp.r;
			int c = temp.c;
			int num = temp.num;
			// 만약에 도착했다면??
			if (r == N - 1 && c == M - 1) {
				System.out.println(num);
				if (min > num) {
					min = num;
				}
				return;
			}
			// 사방으로 가자..
			// 델타 배열 쓸까..
			for (int i = 0; i < 4; i++) {
				// 만약에 가려고 한방향이 된다면??
				if (r + dr[i] < 0 || r + dr[i] >= N || c + dc[i] < 0 || c + dc[i] >= M)
					continue;
				if (visit[r + dr[i]][c + dc[i]] == 1 || arr[r + dr[i]][c + dc[i]] == 0)
					continue;

				// 조건에 맞다면...
				q.offer(new Node(r + dr[i], c + dc[i], num + 1));
				visit[r + dr[i]][c + dc[i]] = 1;

			}
		}

		System.out.println(min);

		// node 번호로 경로개수를 나타낼수도 있구나...
	}
}
