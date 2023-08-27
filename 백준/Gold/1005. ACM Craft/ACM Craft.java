import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int[] time = new int[N + 1];
			int[] indegree = new int[N + 1];
			int[] ans = new int[N + 1];

			boolean[] visit = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				time[i] = sc.nextInt();
			}
			int max = Integer.MAX_VALUE;

			List<Integer>[] list = new ArrayList[N + 1];

			for (int i = 0; i <= N; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < K; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				indegree[b]++;
				list[a].add(b);
			}

			int W = sc.nextInt();

			for (int i = 1; i <= N; i++) {
				int idx = -1;

				for (int j = 1; j <= N; j++) {
					if (!visit[j] && indegree[j] == 0) {
						idx = j;
						break;
					}
				}

				if (idx == -1) {
					continue;
				}
				visit[idx] = true;
				ans[idx] += time[idx];

				if (idx == W) {
					if (max > ans[idx]) {
						max = ans[idx];
						break;
					}
				}

				for (int j = 0; j < list[idx].size(); j++) {
					int a = list[idx].get(j);

					indegree[a]--;

					if (ans[a] < ans[idx]) {
						ans[a] = ans[idx];
					}

				}

			}
			System.out.println(max);
		}

	}
}