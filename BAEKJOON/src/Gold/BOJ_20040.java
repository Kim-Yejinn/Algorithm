package Gold;

import java.util.Scanner;

public class BOJ_20040 {

	static int[] parents;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 점개수
		int m = sc.nextInt(); // 차례의 수

		int ans = 0;
		int flag = 0;

		parents = new int[n];

		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		for (int i = 1; i <= m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();

			if (union(s, e) && flag == 0) {
				ans = i;
				flag = 1;
			}
		}
		System.out.println(ans);

	}

	public static int getParents(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = getParents(parents[x]);
	}

	public static boolean union(int a, int b) {
		int aroot = getParents(a);
		int broot = getParents(b);

		if (aroot == broot) {
			return true;
		}
		if (aroot < broot) {
			parents[broot] = aroot;
		} else {
			parents[aroot] = broot;
		}

		return false;
	}
}
