
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		List<Integer>[] list = new ArrayList[N + 1];
		int[] time = new int[N + 1];
		int[] ans = new int[N + 1];
		int[] indegree = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			time[i] = sc.nextInt();
			while (true) {
				int a = sc.nextInt();
				if (a == -1) {
					break;
				}
				list[a].add(i);
				indegree[i]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int temp = q.poll();
			ans[temp] += time[temp];

			for (int i = 0; i < list[temp].size(); i++) {
				int a = list[temp].get(i);

				if (ans[a] < ans[temp]) {
					ans[a] = ans[temp];
				}
				indegree[a]--;
				if (indegree[a] == 0) {
					q.offer(a);
				}
			}

		}

		for (int i = 1; i <= N; i++) {
			System.out.println(ans[i]);
		}
	}
}
