import java.util.Scanner;

public class SWEA_1954_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			int r = 0, c = 0;
			int flag_r = 0, flag_c = 1;
			int flag_R = N - 1, flag_D = N - 1;
			int flag_L = 0, flag_U = 0;

			for (int num = 1; num <= N * N; r += flag_r, c += flag_c, num++) {
				arr[r][c] = num;

				if (c == flag_R && flag_c == 1 && flag_r == 0) {
					flag_r = 1;
					flag_c = 0;
					flag_U++;
				}

				if (r == flag_D && flag_c == 0 && flag_r == 1) {
					flag_r = 0;
					flag_c = -1;
					flag_R--;
				}
				if (c == flag_L && flag_c == -1 && flag_r == 0) {
					flag_r = -1;
					flag_c = 0;
					flag_D--;
				}
				if (r == flag_U && flag_c == 0 && flag_r == -1) {
					flag_r = 0;
					flag_c = 1;
					flag_L++;
				}

			}
			System.out.println("#" + i);
			for (int m = 0; m < N; m++) {
				for (int n = 0; n < N; n++) {
					System.out.print(arr[m][n] + " ");

				}
				System.out.println();
			}

		}

	}
}
