import java.util.Scanner;

public class BOJ_2567 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] arr = new int[102][102];
		int cnt = 0;

		for (int i = 0; i < N; i++) {

			int a = sc.nextInt();
			int b = sc.nextInt();

			// 색종이 붙이기
			for (int r = 0; r < 10; r++) {
				for (int c = 0; c < 10; c++) {
					arr[r + a + 1][c + b + 1] = 1;
				}
			}
		}
		// 테두리 구하기
		for (int r = 1; r <= 100; r++) {
			for (int c = 1; c <= 100; c++) {
				if (arr[r][c] == 1) {

					for (int j = -1; j <= 1; j++) {
						if (arr[r + j][c] == 0)
							cnt++;
						if (arr[r][c + j] == 0)
							cnt++;
					}

				}
			}
		}

		System.out.println(cnt);

	}

}
