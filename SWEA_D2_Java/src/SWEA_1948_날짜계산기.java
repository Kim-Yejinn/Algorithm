import java.util.Scanner;

public class SWEA_1948_날짜계산기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int[] day = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int i = 1; i <= T; i++) {
			int total_day = 1;
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();

			for (int j = m1; j < m2; j++) {
				total_day += day[j];
			}
			total_day += d2;
			total_day -= d1;

			System.out.printf("#%d %d\n", i, total_day);

		}

	}
}
