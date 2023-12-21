import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			int[][] arr = new int[N][2];
			int[][] memo = new int[N][2];

			// 입력
			for (int c = 0; c < 2; c++) {
				for (int r = 0; r < N; r++) {
					arr[r][c] = sc.nextInt();
				}
			}

			// 왼쪽 부터 가자
			// 1. 위를 선택하는 경우
			// -> i-2 위에꺼 랑 i-1 아래꺼 비교
			// 2. 아래를 선택하는 경우
			// -> i-1 위에꺼랑 i-2 아래꺼 비교
			// 3. 둘다 선택하지 않는 경우

			// 초기 값 채우기
			memo[0][0] = arr[0][0];
			memo[0][1] = arr[0][1];

			if (N >= 2) {
				memo[1][0] = arr[1][0] + arr[0][1];
				memo[1][1] = arr[1][1] + arr[0][0];
			}

			for (int i = 2; i < N; i++) {
				// 위
				if (memo[i - 2][1] < memo[i - 1][1]) {
					memo[i][0] = memo[i - 1][1] + arr[i][0];
				} else {
					memo[i][0] = memo[i - 2][1] + arr[i][0];
				}
				// 아래
				if (memo[i - 2][0] < memo[i - 1][0]) {
					memo[i][1] = memo[i - 1][0] + arr[i][1];
				} else {
					memo[i][1] = memo[i - 2][0] + arr[i][1];
				}
			}
			// 결과
			if (memo[N - 1][1] < memo[N - 1][0]) {
				System.out.println(memo[N - 1][0]);
			} else {
				System.out.println(memo[N - 1][1]);
			}

		} // tc끝
	}
}