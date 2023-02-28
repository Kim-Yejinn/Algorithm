import java.util.Scanner;

public class BOJ_2578 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[5][5];
		int[] ans = new int[12];
		// 0~4 : row / 5~9 : col / 10 :대각 / 11 : 대각

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		int cnt = 0;
		s: for (int i = 0; i < 25; i++) {
			int num = sc.nextInt();
			cnt++;

			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (arr[r][c] == num) {
						ans[r]++;
						ans[c + 5]++;
						if (r == c) {
							ans[10]++;
						}
						if (r + c == 4) {
							ans[11]++;
						}
					}
				}
			}

			int temp = 0;
			for (int j = 0; j < 12; j++) {
				if (ans[j] == 5) {
					temp++;
				}
				if (temp == 3) {
					break s;
				}
			}
		}
		System.out.println(cnt);

	}
}
