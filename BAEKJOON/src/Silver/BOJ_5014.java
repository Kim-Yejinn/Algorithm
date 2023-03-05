package Silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_5014 {
//bfs..
	// 층수랑 번호를 저장해 두자
	public static class Node {
		int stair;
		int num;

		public Node(int stair, int num) {
			super();
			this.stair = stair;
			this.num = num;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int F = sc.nextInt(); // 총 F층
		int S = sc.nextInt(); // 지금 있는층
		int G = sc.nextInt(); // 가야 되는 층
		int U = sc.nextInt(); // 올라갈때 가는 층수
		int D = sc.nextInt(); // 내려갈때 가는 층수

		// 방문 확인
		int[] visit = new int[F + 1];

		// 큐만들자
		Queue<Node> q = new LinkedList<>();

		// 우선 처음 있는 위치 넣자
		q.offer(new Node(S, 0));
		int flag = 0;
		while (!q.isEmpty()) {
			// 하나 빼구
			Node temp = q.poll();

			int stair = temp.stair;
			int num = temp.num;

			if (stair == G) {
				// 도착하면
				// 버튼수 출력
				System.out.println(num);
				flag = 1;
				return;
			}
			if (visit[stair] == 1)
				continue;
			if (visit[stair] == 0) {
				// 방문 안했을 경우
				visit[stair] = 1;
				// 위로 가구
				// 만약 층수보다 높아지면 안되니까
				if (stair + U <= F) {
					q.offer(new Node(stair + U, num + 1));
				}

				// 아래로 가자
				if (stair - D >= 1) {
					q.offer(new Node(stair - D, num + 1));
				}
			}
		}
		// 만약 끝났는데 안되었다면..
		if (flag == 0) {
			System.out.println("use the stairs");
		}

	}
}
