import java.util.Scanner;

public class SWEA_1215_회문1_2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {

			int N = sc.nextInt();
			int[][] arr = new int[8][8];

			for (int r = 0; r < 8; r++) {
				String temp = sc.next();
				for (int c = 0; c < 8; c++) {
					arr[r][c] = temp.charAt(c);
				}
			}
			int cnt = 0;

			for (int r = 0; r < 8; r++) {

				for (int c = 0; c < 9 - N; c++) {
					boolean flag1 = true;
					boolean flag2 = true;
					for (int t = 0; t < N / 2; t++) {
						if (arr[r][c + t] != arr[r][c + N - 1 - t]) {
							flag1 = false;
						}
						if (arr[c + t][r] != arr[c + N - 1 - t][r]) {
							flag2 = false;
						}

					}
					if (flag1 == true)
						cnt++;
					if (flag2 == true)
						cnt++;
				}
			}
			System.out.printf("#%d %d\n", i, cnt);

		}

	}
}
