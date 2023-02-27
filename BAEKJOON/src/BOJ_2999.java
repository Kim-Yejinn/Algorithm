import java.util.Scanner;

public class BOJ_2999 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int N = str.length();

		int num = 1;
		for (int i = 1; i < N; i++) {
			if (i * (N / i) == N) {
				if (i <= N / i) {
					num = i;
				} else {
					break;
				}
			}
		}

		char[][] arr = new char[num][N / num];

		int idx = 0;
		for (int c = 0; c < N / num; c++) {
			for (int r = 0; r < num; r++) {
				arr[r][c] = str.charAt(idx++);

			}
		}
		for (int r = 0; r < num; r++) {
			for (int c = 0; c < N / num; c++) {
				System.out.print(arr[r][c]);
			}
		}

	}
}
