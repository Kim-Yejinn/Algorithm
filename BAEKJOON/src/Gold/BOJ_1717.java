package Gold;

import java.util.Scanner;

public class BOJ_1717 {
	// union find 문제

	// 부모 노드에 대한 것을 저장하는 배열
	static int[] parents;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		// 번호로 쓸거기 땜에 1더해서 한다
		parents = new int[n + 1];

		// 각각 자기 자신을 가리키도록 한다.
		// (노드가 연결x)
		for (int i = 0; i < n + 1; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int op = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			// 0일 경우 합집합
			// 1의 경우 확인

			if (op == 0) {
				union(parents, a, b);
			} else if (op == 1) {
				find(parents, a, b);
			}
		}

	}

	// 부모 가져오는 함수
	public static int getParents(int[] parents, int x) {
		// 만약 자기 자신을 가르킨다면 자기 자신을 리턴한다
		if (parents[x] == x)
			return x;
		// 아니라면 연결된거 따라 가본다.
		// 그러고 그 값을 리턴한다
		return parents[x] = getParents(parents, parents[x]);
	}

	// 부모 합치는 함수
	public static void union(int[] parents, int a, int b) {
		// 각각을 받아온다
		int aroot = getParents(parents, a);
		int broot = getParents(parents, b);

		// 더 작은 쪽에 합친다
		if (aroot < broot) {
			// b가 더 크니 b에다가 a를 넣자
			parents[broot] = aroot;
		} else {
			parents[aroot] = broot;
		}
	}

	// 같은 부모인지 확인하는 함수
	public static void find(int[] parents, int a, int b) {
		// 각각 가져오자
		int aroot = getParents(parents, a);
		int broot = getParents(parents, b);

		if (aroot == broot) {
			// 같다면 yes출력
			System.out.println("YES");
		} else {
			// 다르다면 No출력
			System.out.println("NO");
		}
	}

}
