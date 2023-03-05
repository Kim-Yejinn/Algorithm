package Silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1926 {
	public static class Node {

		int x;
		int y;

		// 생성자두..
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] arr = new int[n][m];
		int[][] visit = new int[n][m];

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		// 최대 넓이 저장
		int max = 0;
		// 그림 개수 저장
		int cnt = 0;

		// 그림 시작점!
		// 큐에 넣고 주변을 탐색하자ㅣ
		Queue<Node> q = new LinkedList<Node>();

		// 전체를 돌면서 시작점을 고르자
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				// 만약 그림이 아닌데??
				// 그리고 이미 왔네??
				// 그냥 다음꺼하자
				if (visit[r][c] == 1 || arr[r][c] == 0)
					continue;

				// 시작하자
				int area = 0;

				// 우선 시작점 넣어야지..
				// 노드로 x, y 저장해둬야겠당.
				q.offer(new Node(c, r));
				visit[r][c] = 1;

				while (!q.isEmpty()) {
					// 주변 탐색할꺼 안남을때까지
					// 즉 큐에 다 떨어졌을때까지
					// 우선 하나꺼내구
					Node temp = q.poll();

					// 넓이도 하나 추가 시키고..
					area++;
					int x = temp.x;
					int y = temp.y;
					// 왼쪽으로 계속 가자..
					if (x > 0 && visit[y][x - 1] == 0 && arr[y][x - 1] == 1) {
						// 방문도 안했구,, 왼쪽으로 갈수도 있고,, 그림도 있다면..
						q.offer(new Node(x - 1, y));
						// 방문 표시
						visit[y][x - 1] = 1;
					}

					// 오른
					if (x < m - 1 && visit[y][x + 1] == 0 && arr[y][x + 1] == 1) {
						// 방문도 안했구,, 오른쪽으로 갈수도 있고,, 그림도 있다면..
						q.offer(new Node(x + 1, y));
						// 방문 표시
						visit[y][x + 1] = 1;
					}
					// 위
					if (y > 0 && visit[y - 1][x] == 0 && arr[y - 1][x] == 1) {
						// 방문도 안했구,, 위쪽으로 갈수도 있고,, 그림도 있다면..
						q.offer(new Node(x, y - 1));
						// 방문 표시
						visit[y - 1][x] = 1;
					}

					// 아래
					if (y < n - 1 && visit[y + 1][x] == 0 && arr[y + 1][x] == 1) {
						// 방문도 안했구,, 아래쪽으로 갈수도 있고,, 그림도 있다면..
						q.offer(new Node(x, y + 1));
						// 방문 표시
						visit[y + 1][x] = 1;
					}
					if (max < area) {
						max = area;
					}

				}
				cnt++;

			}
		}

		// 다돌았다..
		// 출력하자
		System.out.println(cnt);
		System.out.println(max);
	}
}
