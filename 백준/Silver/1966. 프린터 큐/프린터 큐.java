import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			List<Integer> list = new LinkedList<>();
			int num = 0;
			for (int j = 0; j < N; j++) {
				int temp = sc.nextInt();
				q.add(temp);
				if (j == M) {
					num = temp;
				}
			}

			for (int j = 0; j < N; j++) {
				int temp = q.poll();
				if (temp > num) {
					list.add(temp);
				}
				q.add(temp);
			}
			Collections.sort(list, Collections.reverseOrder());

			int cnt = 0;
			int idx = M;

			while (true) {
				if (list.isEmpty() && idx == 0) {
					cnt++;
					break;
				}
				int temp = q.poll();
				idx--;

				if (!list.isEmpty() && list.get(0) != temp) {
					q.add(temp);
					cnt--;
				}
				if (list.isEmpty() && temp != num) {
					q.add(temp);
					cnt--;
				}
				if (!list.isEmpty() && list.get(0) == temp) {
					list.remove(0);
				}
				if (idx < 0) {
					idx = q.size() - 1;
				}

				cnt++;
			}
			System.out.println(cnt);
		}
	}
}
