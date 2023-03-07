package Gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_9205 {
	// bfs
	// 큐..

	public static class Node {
		int x;
		int num;

		public Node(int x, int num) {
			super();
			this.x = x;
			this.num = num;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		int offset = 700;

		int[] dx = { 50, -50 };

		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			Queue<Node> q = new LinkedList<>();
			int[] visit = new int[2800];
			int inx = sc.nextInt();
			int iny = sc.nextInt();

			q.offer(new Node(inx + iny, 20));

			Node[] store = new Node[n];

			for (int i = 0; i < n; i++) {
				store[i] = new Node(sc.nextInt() + sc.nextInt(), 20);
			}

			int fx = sc.nextInt() + sc.nextInt(); // 도착

			int flag = 0;
			s: while (!q.isEmpty()) {
				Node temp = q.poll();
				int x = temp.x;
				int num = temp.num;

//				System.out.println(x);
//				System.out.println(num);
//				System.out.println(fx);
				// 도착 했으면 happy
				// 거리가 50 이하일때
				// 편의점 도착하면 20채우기
				for (int j = 0; j < n; j++) {
					Node sto = store[j];
					if (visit[sto.x / 50 + offset] == 1) {
						continue;
					}
					if (Math.abs(sto.x - x) < 50) {
						q.offer(new Node(sto.x, 20));
						visit[x / 50 + offset] = 1;
						continue s;
					}
				}

				if (Math.abs(fx - x) <= 50 && num > 0) {
					flag = 1;
					break;
				}
				// 만약 0이라면 sad
				if (num == 0) {
					continue;
				}

				visit[x / 50 + offset] = 1;

				// 아니라면 1씩 감소시키기
				for (int i = 0; i < 2; i++) {
					int nx = x + dx[i];
					if (visit[nx / 50 + offset] == 1) {
						continue;
					}
					q.offer(new Node(nx, num - 1));
				}
			}
			if (flag == 1) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}

		}

	}
}
