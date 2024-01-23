import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static class Node {
		int distance;
		int time;

		public Node(int distance, int time) {
			this.distance = distance;
			this.time = time;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int min = Integer.MAX_VALUE;
		int cnt = 0;

		Queue<Node> q = new LinkedList<>();
		int[] visit = new int[100001];

		q.offer(new Node(N, 0));
		visit[N] = 0;

		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.distance == K) {
				if (min > temp.time) {
					min = temp.time;
					cnt = 1;
				} else {
					cnt++;
				}
			}

			if (temp.time >= min) {
				continue;
			}

			for (int i = 0; i < 3; i++) {
				int nd = 0;
				if (i == 0) {
					nd = temp.distance * 2;
				}
				if (i == 1) {
					nd = temp.distance + 1;
				}
				if (i == 2) {
					nd = temp.distance - 1;
				}
				if (nd > 100000 || nd < 0) {
					continue;
				}
				if (visit[nd] != 0 && visit[nd] < temp.time + 1) {
					continue;
				}
				visit[nd] = temp.time + 1;
				q.offer(new Node(nd, temp.time + 1));
			}
		}
		System.out.println(min);
		System.out.println(cnt);
	}
}
