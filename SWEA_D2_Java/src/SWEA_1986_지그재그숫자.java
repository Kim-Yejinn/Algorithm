import java.util.Scanner;

public class SWEA_1986_지그재그숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int in_f = sc.nextInt();
		int sum = in_f;
		System.out.printf("#1 %d\n", sum);

		for (int i = 2; i <= T; i++) {
			int input = sc.nextInt();

			if (i % 2 == 1)
				sum += input;
			else
				sum -= input;

			System.out.printf("#%d %d\n", i, sum);

		}
	}
}
