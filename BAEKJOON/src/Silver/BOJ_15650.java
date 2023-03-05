package Silver;

import java.util.Scanner;

public class BOJ_15650 {
	static int M, N;
	// 선택할 숫자를 넣어둘 곳
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		// 선택할 것은 그냥 넣기만 하면 되기 때문에..
		arr = new int[M];

		// 0번째 숫자부터 확인해보자
		permutation(0, 1);

	}

	public static void permutation(int num, int start) {
		// num 번째 숫자를 선택하자
		// 선택해서 arr에 넣자
		if (num == M) {
			// 만약 마지막 수까지 선택 완료라면
			// 출력하자
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;

		}
		for (int i = start; i <= N; i++) {
			// 숫자를 다 돌면서
			arr[num] = i;
			// 다음 숫자 선택하자
			permutation(num + 1, i + 1);
		}
	}
}
