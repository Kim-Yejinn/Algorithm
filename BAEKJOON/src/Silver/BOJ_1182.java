package Silver;

import java.util.Scanner;

public class BOJ_1182 {
	static int[] arr;
	static int cnt;
	static int N;
	static int S;
	static int[] sum;
	static int end;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();

		arr = new int[N];
		cnt = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			sum = new int[i];
			end = i;
			permutation(0, 0);
		}
		System.out.println(cnt);
	}

	public static void permutation(int num, int start) {
		if (num == end) {
			// 선택 끝
			// 다더한것이 같은가??
			int temp = 0;
			for (int i = 0; i < end; i++) {
				temp += sum[i];
			}
			if (S == temp) {
				cnt++;
			}
			return;
		}

		for (int i = start; i < N; i++) {
			// 하나씩 고르자...
			sum[num] = arr[i];
			// 넣고..
			// 다음꺼 ㄱㄱ
			// 다음 숫자 부터 고르자
			permutation(num + 1, i + 1);
		}
	}

}
