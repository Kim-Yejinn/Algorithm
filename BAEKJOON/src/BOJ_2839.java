import java.util.Scanner;

public class BOJ_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int div_3 = N / 3;
		int div_5 = N / 5;

		int min = 10000;
		for (int i = 0; i <= div_3; i++) {
			for (int j = 0; j <= div_5; j++) {
				if (i * 3 + j * 5 == N) {
					if (min > i + j) {
						min = i + j;
					}
				}
			}
		}

		if (min == 10000)
			System.out.println(-1);
		else
			System.out.println(min);

	}
}
