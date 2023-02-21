import java.util.Scanner;

public class BOJ_2851 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int sum = 0;
		int p_sum = 0;

		for (int i = 0; i < 10; i++) {

			int temp = sc.nextInt();
			sum += temp;

			if (i == 0 && sum > 200) {
				System.out.println(sum);
				break;
			}

			if (sum >= 100) {
				if (sum - 100 <= 100 - p_sum) {
					System.out.println(sum);
				} else if (sum - 100 > 100 - p_sum) {
					System.out.println(p_sum);
				}
				break;
			}
			p_sum = sum;

			if (i == 9) {
				System.out.println(sum);
			}
		}

	}
}
