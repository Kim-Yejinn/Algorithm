import java.util.Scanner;

public class SWEA_1970_쉬운거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();

			int[] re_money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

			System.out.println("#" + i);
			int temp = N;
			int num = 0;
			for (int j = 0; j < re_money.length; j++) {

				num = temp / re_money[j];
				temp -= re_money[j] * num;
				System.out.printf("%d ", num);
				num = 0;

			}
			System.out.println();
		}

	}
}
