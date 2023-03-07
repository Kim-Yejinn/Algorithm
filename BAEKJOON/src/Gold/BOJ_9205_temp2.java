package Gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_9205_temp2 {
	// bfs
	// 큐..

	public static class Node {
		int x;
		int y;

		public Node(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}

		int num;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		int offset = 700;

		int[] dx = { 50, 0, -50, 0 };
		int[] dy = { 0, 50, 0, -50 };

		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			Queue<Node> q = new LinkedList<>();
			int[] visitx = new int[1400];
			int[] visity = new int[1400];
			int inx = sc.nextInt();
			int iny = sc.nextInt();

			q.offer(new Node(inx, iny, 20));

			Node[] store = new Node[n];

			for (int i = 0; i < n; i++) {
				store[i] = new Node(sc.nextInt(), sc.nextInt(), 20);
			}

			int fx = sc.nextInt();// 도착
			int fy = sc.nextInt(); // 도착

			int flag = 0;
			s: while (!q.isEmpty()) {
				Node temp = q.poll();

				int x = temp.x;
				int y = temp.y;
				int num = temp.num;

				// 도착 했으면 happy
				// 거리가 50 이하일때

				for (int j = 0; j < n; j++) {
					Node sto = store[j];
					if (visitx[sto.x / 50 + offset] == 1 && visity[sto.y / 50 + offset] == 1) {
						continue;
					}
					if ((Math.abs(sto.x - x) + Math.abs(sto.y - y)) < 50) {
						q.offer(new Node(sto.x, sto.y, 20));
						visitx[sto.x / 50 + offset] = 1;
						visity[sto.y / 50 + offset] = 1;
						continue s;
					}
				}
				// 만약 0이라면 sad
				if ((Math.abs(fx - x) + Math.abs(fy - y)) <= 50 && num > 0) {
					flag = 1;
					break;
				}
				if (num == 0) {
					continue;
				}
				visitx[x / 50 + offset] = 1;
				visity[y / 50 + offset] = 1;

				// 편의점 도착하면 20채우기

				// 아니라면 1씩 감소시키기
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (visitx[nx / 50 + offset] == 1 && visity[ny / 50 + offset] == 1) {
						continue;
					}

					q.offer(new Node(nx, ny, num - 1));
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
