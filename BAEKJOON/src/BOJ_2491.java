import java.util.Scanner;

public class BOJ_2491 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int pre = sc.nextInt();
		int cnt = 1;

		int temp_up = 1;
		int temp_down = 1;

		for (int i = 1; i < N; i++) {
			int temp = sc.nextInt();

			if (pre <= temp) {
				temp_up++;
				if (temp_up > cnt) {
					cnt = temp_up;
				}
				if (pre != temp) {
					temp_down = 1;
				}
			}
			if (pre >= temp) {
				temp_down++;
				if (temp_down > cnt) {
					cnt = temp_down;
				}
				if (pre != temp) {
					temp_up = 1;
				}

			}
			pre = temp;

		}
		System.out.println(cnt);

	}
}
