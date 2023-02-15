import java.util.Scanner;

public class SWEA_7964_부먹왕국의차원관문 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();

			int D = sc.nextInt();

			int cnt = 0;
			int check_D = 0;
			for (int j = 0; j < N; j++) {
				int temp = sc.nextInt();
				if (temp == 0) {
					check_D++;
				} else {
					check_D = 0;
				}
				if (check_D == D) {
					cnt++;
					check_D = 0;
				}

			}
			System.out.printf("#%d %d\n", i, cnt);
		}

	}
}
