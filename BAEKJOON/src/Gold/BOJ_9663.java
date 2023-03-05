package Gold;

import java.util.Scanner;

public class BOJ_9663 {
	// N-Queen

	static int[] c;
	static int N;
	static int cnt;
	static int[] arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		// 숫자 확인하자! 이건 숫자로 쓸꺼니까 1더해주자
		c = new int[N + 1];
		// 고른 숫자넣을 곳을 정의하자 이건 N개 고를거임
		arr = new int[N];

		cnt = 0;
		// 고르는건 0번 인덱스 숫자부터 고르는거지
		permutation(0);

		// 재귀 끝났다 = 다 찾았다.
		System.out.println(cnt);
	}

	public static void permutation(int num) {
		// num번째의 숫자를 골라보자
		if (num == N) {
			// 모든 수를 골랐다!
			// 카운트 하자
			cnt++;
			return;

		}
		// 수가 덜 찼으니 골라야됨
		s: for (int i = 1; i <= N; i++) {
			// 해당 수 사용했는가??
			if (c[i] == 0) {
				// 사용 ㄴㄴ

				// 만약에 이전 수가 대각선에 있으면 ?????
				int k = num; // 지금 넣을 위치
				// 왼쪽으로 j 만큼 1부터 처음 까지 가면서
				for (int j = 1; k - j >= 0; j++) {
					// j만큼 증가 j 만큼 감소의 값이 있을 경우 이건 대각임
					if (arr[k - j] == i + j || arr[k - j] == i - j) {
						// 왼쪽으로 가면서 가로 길이만큼 올라간값, 내려간 값이 있으면
						// 이건 대각선 들어간거
						// 그러니 ㄴㄴ임
						// 그냥 나가자;;;
						continue s;
					}
				}

				// 선택한 목록에 넣자
				arr[num] = i;
				c[i] = 1;
				// 선택한건 사용했다.
				// 이제 다음수 ㄱㄱ
				permutation(num + 1);
				// 다 갔다 왔으니 이제 이 숫자는 false하고 다음꺼 쓸까
				c[i] = 0;
			}

		}
		return;
	}
}