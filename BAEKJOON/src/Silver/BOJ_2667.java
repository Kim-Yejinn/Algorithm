package Silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2667 {
	// 너비 우선 탐색

	// 노드에 필요한 정보는
	// row, col 좌표..
	static class Node {
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

		// 지도 크기
		int N = sc.nextInt();

		// 지도
		int[][] arr = new int[N][N];

		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < N; c++) {
				arr[r][c] = str.charAt(c) - '0';
			}
		}

		// 큐를 만들자...
		Queue<Node> q = new LinkedList<>();

		// 집의 수를 넣어 주자..
		// 리스트 쓸까..
		List<Integer> list = new ArrayList<Integer>();

		// 방문 확인
		int[][] visit = new int[N][N];

		// 상하 좌우 이동
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		// 돌면서 집부터 찾자
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {

				// 이미 방문했음 -> 버렷
				// 숫자도 아님 -> 버렷
				if (arr[r][c] == 0)
					continue;
				if (visit[r][c] == 1)
					continue;

				// 찾았다.
				// 우선 지금꺼 큐에 넣자
				q.offer(new Node(r, c));
				// 방문도
				visit[r][c] = 1;
				int cnt = 1;

				while (!q.isEmpty()) {
					// 우선 하나꺼내주고
					Node temp = q.poll();

					// 사용 편하게 변수로 받자
					int tr = temp.r;
					int tc = temp.c;

					// 상하 좌우 돌자
					// 델타 배열 쓰자

					for (int i = 0; i < 4; i++) {
						// 가려는 곳에 조건이 맞는지 확인하자
						int nr = tr + dr[i];
						int nc = tc + dc[i];

						if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1) {
							continue;
						}
						if (arr[nr][nc] == 0 || visit[nr][nc] == 1) {
							continue;
						}
						// 조건에 맞으면 큐에 넣어 주자..
						q.offer(new Node(nr, nc));
						// 방문도
						visit[nr][nc] = 1;

						// 큐에 넣은것 == 그것도 단지에 포함이구나
						// 카운트 하자
						cnt++;
					}

				}
				// 다 돌고 온 뒤
				// 카운트 된건 단지내 집수
				// 리스트에 넣어두자.
				list.add(cnt);

			}
		}

		// 다하고 오면 리스트에는 단지의 집수가 들어가있음
		// list 크기 == 단지 수

		// 오름 차순 해주고
		Collections.sort(list);

		// 출력하자
		// 단지수
		System.out.println(list.size());
		// 집들
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
