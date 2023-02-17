import java.util.Scanner;

public class SWEA_1859_백만장자프로젝트 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();

			long sum = 0;
			int day = 0;
			int day_2 = 0;
			int max_price = 0;
			long sum_temp = 0;

			int[] price = new int[N];

			for (int j = 0; j < N; j++) {
				price[j] = sc.nextInt();
			}

			do {
				day = N - 1;
				max_price = price[N - 1];

				for (int j = N - 1; j >= day_2; j--) {
					sum_temp += (price[day] - price[j]);

					if (max_price < price[j]) {
						day = j;
						max_price = price[j];
						sum_temp = 0;
					}
				}
				sum += sum_temp;
				sum_temp = 0;
				day_2 = day + 1;

			} while (day != N - 1);
			System.out.println("#" + i + " " + sum);
		}

	}
}
