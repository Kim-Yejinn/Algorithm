import java.util.Scanner;

public class SWEA_1984_중간평균값구하기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int sum = 0, max = 0, min = 10000;

			for (int j = 0; j < 10; j++) {
				int temp = sc.nextInt();

				sum += temp;
				if (max < temp)
					max = temp;

				if (min > temp)
					min = temp;
			}

			sum -= max + min;

			System.out.printf("#%d %d\n", i, Math.round(sum * 1.0 / 8));

		}

	}
}
