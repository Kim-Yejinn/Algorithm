import java.util.Scanner;

public class BOJ_2477 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		int[] line = new int[6];

		int pre = 0;

		int min = 0;
		int max_a = 0;
		int max_b = 0;
		int flag = 0;
		for (int i = 0; i < 6; i++) {
			int temp = sc.nextInt();
			line[i] = sc.nextInt();

			if (i % 2 == 0 && line[i] > max_a) {
				max_a = line[i];
			}
			if (i % 2 == 1 && line[i] > max_b) {
				max_b = line[i];
			}

			if (pre != 0) {
				if ((pre == 4 && temp == 2) || (pre == 2 && temp == 3) || (pre == 3 && temp == 1)
						|| (pre == 1 && temp == 4)) {

				} else {
					min = line[i] * line[i - 1];
					pre = 0;
					flag = 1;
				}

			}

			pre = temp;

		}
		if (flag == 0) {
			min = line[0] * line[5];
		}
		System.out.println(K * (max_a * max_b - min));

	}
}
