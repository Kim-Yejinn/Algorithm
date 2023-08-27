import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt = 0;

		int temp_sum = 0;
		int cycle_N = N;
		int t1 = 0, t2 = 0;

		do {
			if (cycle_N < 10) {
				temp_sum = cycle_N;
				cycle_N = temp_sum * 10 + temp_sum;
			} else {
				t1 = cycle_N / 10;
				t2 = cycle_N % 10;

				temp_sum = t1 + t2;
				cycle_N = t2 * 10 + temp_sum % 10;
			}

			cnt++;
		} while (N != cycle_N);
		System.out.println(cnt);

	}
}
