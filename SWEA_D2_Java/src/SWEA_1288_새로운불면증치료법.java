import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1288_새로운불면증치료법 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int[] flag = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			int out = 0;
			int cnt = 0;

			long input = sc.nextLong();

			while (out != 1) {
				cnt++;

				long temp = input * cnt;
				for (int j = 0; temp > 0; j++) {
					int n = (int) temp % 10;
					flag[n] = 1;
					temp /= 10;
				}
				if (Arrays.stream(flag).sum() == 10) {
					out = 1;
					System.out.printf("#%d %d\n", i, cnt * input);
				}
			}
		}

	}
}
