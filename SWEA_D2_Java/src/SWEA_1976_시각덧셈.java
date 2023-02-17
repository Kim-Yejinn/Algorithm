import java.util.Scanner;

public class SWEA_1976_시각덧셈 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int H1 = sc.nextInt();
			int M1 = sc.nextInt();

			int H2 = sc.nextInt();
			int M2 = sc.nextInt();

			int tol_Min = M1 + M2;
			int tol_Hour = H1 + H2;

			if (tol_Min > 60) {
				tol_Min -= 60;
				tol_Hour += 1;
			}
			if (tol_Hour > 12) {
				tol_Hour -= 12;
			}
			System.out.printf("#%d %d %d\n", i, tol_Hour, tol_Min);

		}

	}
}
