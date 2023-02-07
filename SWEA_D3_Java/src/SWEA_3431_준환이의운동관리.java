import java.util.Scanner;

public class SWEA_3431_준환이의운동관리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {

			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();

			if (X >= L && X <= U) {
				System.out.printf("#%d %d\n", i, 0);
			} else if (X < L) {
				System.out.printf("#%d %d\n", i, L - X);
			} else
				System.out.printf("#%d %d\n", i, -1);
		}
	}
}
