import java.util.Scanner;

public class BOJ_10163 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] arr = new int[1001][1001];
		for (int i = 1; i <= N; i++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();

			for (int r = row; r < row + width; r++) {
				for (int c = col; c < col + height; c++) {
					arr[r][c] = i;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int r = 0; r < 1001; r++) {
				for (int c = 0; c < 1001; c++) {
					if (arr[r][c] == i) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}

	}
}
