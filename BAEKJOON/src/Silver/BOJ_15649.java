package Silver;

import java.util.Scanner;

public class BOJ_15649 {
	static int[] c;
	static int N;
	static int M;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 전체 수
		M = sc.nextInt(); // 개수

		c = new int[N + 1];
		arr = new int[N];

		permutation(0);
	}

	public static void permutation(int num) {

		if (num == M) { // 다 골랐을 때
			// 출력하자ㅏㅏ
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		// 골라야 됨
		for (int i = 1; i <= N; i++) {
			// 숫자 돌면서
			if (c[i] == 0) {
				// 해당 숫자 사용 안했으면
				// num번째 숫자로 선택
				arr[num] = i;
				// 사용 표시
				c[i] = 1;
				// 다음 숫자로 가서 하나 더 고르자.
				permutation(num + 1);
				// 해당 번째 다 구했다
				// 즉 첫번째로 고른거 다씀!
				c[i] = 0;
				// 나중에 다음 숫자를 처음으로 고르고
				// for문 와서 다른 숫자로 시작하자!
			}

		}

	}
}
