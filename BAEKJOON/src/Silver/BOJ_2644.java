package Silver;

import java.util.Scanner;

public class BOJ_2644 {
	// 촌수계산..
	// 이건 dfs닷

	// 사람 수 = 노드수
	static int N;
	// 방문 확인 필요함
	static int[] c;
	// 연결 관계를 확인하자
	static int[][] arr;
	// 연결 된거 수
	static int m;

	static int find;
	static int cnt;
	static int flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		c = new int[N + 1];
		arr = new int[N + 1][N + 1];
		cnt = 0;
		flag = 0;

		// 시작
		int start = sc.nextInt();
		// 찾을것
		find = sc.nextInt();
		m = sc.nextInt();
		// 입력받자
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			arr[a][b] = arr[b][a] = 1;
		}

		// 가즈ㅏㅏ
		dfs(start);

		// 다갔다 왔다.
		// 원하는 c가 방문표시가 되었다??
		// 카운트 한거를 하자
		if (c[find] == 1) {
			System.out.println(cnt);
		} else {
			// 아닐 경우 못갔다..
			System.out.println(-1);
		}
	}

	public static void dfs(int num) {
		// 만약에 이미 왔다?? ㄴㄴㄴ
		if (c[num] == 1)
			return;

		// 만약 우리가 원하는 값을 찾았다?
		// 끝내자
		c[num] = 1;
		if (c[find] == 1) {
			flag = 1;
			return;
		}
		// 온게 아니다?
		// 왔다고 하고
		// 연결된걸 가보자
		for (int i = 1; i < arr[num].length; i++) {
			// 만약 연결 되었다?
			if (arr[num][i] == 1) {
				// ㄱㄱ 가즈아
				dfs(i);
			}
		}
		// 값 찾았고 돌아가는 과정에 길이를 구하자!
		if (flag == 1)
			cnt++;

	}
}
