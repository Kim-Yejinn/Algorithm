import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_11650 {
	static class xy {
		int x;
		int y;

		public xy(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return x + " " + y;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		PriorityQueue<xy> pq = new PriorityQueue<>(new Comparator<xy>() {

			@Override
			public int compare(xy o1, xy o2) {
				if (o1.x == o2.x) {
					return o1.y - o2.y;
				} else {
					return o1.x - o2.x;
				}
			}

		});
		for (int i = 0; i < N; i++) {

			pq.offer(new xy(sc.nextInt(), sc.nextInt()));

		}
		for (int i = 0; i < N; i++) {
			System.out.println(pq.poll());
		}
	}
}
