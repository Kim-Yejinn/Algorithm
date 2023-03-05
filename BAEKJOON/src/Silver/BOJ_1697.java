package Silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697 {
	// 너비..?
	public static class Node {
		int distance;
		int time;

		public Node(int distance, int time) {
			super();
			this.distance = distance;
			this.time = time;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		// 배수가 되냐 한칸을 이동하는가..
		Queue<Node> q = new LinkedList<>();
		int[] visit = new int[100001];
		q.offer(new Node(N, 0));

		while (!q.isEmpty()) {

			Node temp = q.poll();
			int dis = temp.distance;
			int time = temp.time;

			if (dis < 0) {
				continue;
			}
			if (dis > 100000) {
				continue;
			}
			if (visit[dis] == 1) {
				continue;
			}
			visit[dis] = 1;
			if (dis == K) {
				System.out.println(time);
				return;
			}
			q.offer(new Node(dis * 2, time + 1));
			q.offer(new Node(dis + 1, time + 1));
			q.offer(new Node(dis - 1, time + 1));

		}

	}
}
