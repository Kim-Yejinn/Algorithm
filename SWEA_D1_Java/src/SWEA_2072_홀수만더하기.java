import java.util.Scanner;

public class SWEA_2072_홀수만더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int[] num = new int[10];
		int total = 0;

		for (int i = 1; i <= T; i++) {
			for (int j = 0; j < 10; j++) {
				num[j] = sc.nextInt();

				if (num[j] % 2 != 0)
					total += num[j];
			}

			System.out.println("#" + i + " " + total);
			total = 0;

		}

	}
}
