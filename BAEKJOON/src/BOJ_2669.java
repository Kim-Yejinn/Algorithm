import java.util.Scanner;

public class BOJ_2669 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = 0;

		boolean[][] arr = new boolean[101][101];
		for (int i = 0; i < 4; i++) {

			int r1 = sc.nextInt();
			int c1 = sc.nextInt();
			int r2 = sc.nextInt();
			int c2 = sc.nextInt();

			for (int r = r1; r < r2; r++) {
				for (int c = c1; c < c2; c++) {
					arr[r][c] = true;
				}
			}
		}
		for (int r = 1; r <= 100; r++) {
			for (int c = 1; c <= 100; c++) {
				if (arr[r][c] == true) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
