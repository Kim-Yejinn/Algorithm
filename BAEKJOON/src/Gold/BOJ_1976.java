package Gold;

import java.util.Scanner;

public class BOJ_1976 {
//union find 문제

	static int[] parents;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int M = sc.nextInt();
		parents = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}

		int[][] arr = new int[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				arr[r][c] = sc.nextInt();
				if (arr[r][c] == 1) {
					union(parents, r, c);
				}
			}
		}

		int[] ans = new int[M];

		for (int i = 0; i < M; i++) {
			ans[i] = sc.nextInt();
		}

		int flag = 0;

		for (int i = 1; i < M; i++) {
			if (!find(parents, ans[i - 1], ans[i])) {
				flag = 1;
			}
		}

		if (flag == 0) {
			System.out.println("YES");
		} else if (flag == 1) {
			System.out.println("NO");
		}
	}

	public static int getParents(int[] parents, int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = getParents(parents, parents[x]);
	}

	public static void union(int[] parents, int a, int b) {
		int aroot = getParents(parents, a);
		int broot = getParents(parents, b);

		if (aroot < broot) {
			parents[broot] = aroot;
		} else {
			parents[aroot] = broot;
		}
	}

	public static boolean find(int[] parents, int a, int b) {
		int aroot = getParents(parents, a);
		int broot = getParents(parents, b);

		if (aroot == broot) {
			return true;
		} else {
			return false;
		}
	}

}
