import java.util.Scanner;

public class SWEA_5432_쇠막대기자르기2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			char[] arr = sc.next().toCharArray();

			boolean flag = true;
			int stick = 0;
			int cnt = 0;
			for (int j = 0; j < arr.length; j++) {

				if (arr[j] == '(') {
					stick++;
					flag = false;

				} else if (arr[j] == ')') {
					if (flag == false) {
						stick--;
						cnt += stick;
					} else {
						cnt++;
						stick--;
					}

					flag = true;

				}

			}
			System.out.printf("#%d %d\n", i, cnt);

		}

	}
}
