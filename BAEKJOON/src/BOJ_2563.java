import java.util.Scanner;

public class BOJ_2563 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int[][] arr = new int[100][100];
		int cnt = 0;
		for (int i = 0; i < T; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			cnt = 0;

			for (int r = 0; r < 10; r++) {
				for (int c = 0; c < 10; c++) {
					arr[x + r][y + c] = 1;
				}
			}

			for (int r = 0; r < 100; r++) {

				for (int c = 0; c < 100; c++) {
					if (arr[r][c] == 1) {
						cnt++;
					}
				}
			}

		}
		System.out.println(cnt);

	}
}
