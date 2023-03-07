package Gold;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_4195 {
	static int[] c;
	static int[] parents;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int F = sc.nextInt();
			c = new int[F];
			parents = new int[F];

			for (int i = 0; i < F; i++) {

				List<String> list = new ArrayList<String>();
				String str1 = sc.next();
				String str2 = sc.next();

				int flag1 = 0;
				int flag2 = 2;

				int num1 = 0;
				int num2 = 0;
				for (int j = 0; j < list.size(); j++) {
					if (list.size() != 0) {
						if (list.get(j).equals(str1)) {
							num1 = j;
						} else {
							if (j == list.size() - 1) {
								list.add(str1);
								num1 = j;
							}
						}
					} else {
						list.add(str1);
						num1 = j;
						break;
					}
					if (list.get(j).equals(str2)) {
						num2 = j;
					} else {
						if (j == list.size() - 1) {
							list.add(str2);
							num2 = j;
						}
					}
				}

				union(parents, num1, num2);
				int cnt = 0;
				for (int k = 0; k < list.size(); k++) {
					System.out.println(num1);
					System.out.println(k);
					if (find(parents, num1, k) == 1) {
						cnt++;
					}
				}
				System.out.println(cnt);
			}
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
			broot = getParents(parents, aroot);
		} else {
			aroot = getParents(parents, broot);
		}
	}

	public static int find(int[] parents, int a, int b) {
		int aroot = getParents(parents, a);
		int broot = getParents(parents, b);
		if (aroot == broot) {
			return 1;
		} else {
			return 0;
		}
	}

}
