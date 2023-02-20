import java.util.Scanner;

public class SWEA_5432_쇠막대기자르기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			String input = sc.next();

			int stick = 0;
			int part = 0;
			boolean flag = false;

			for (int j = 0; j < input.length(); j++) {
				char temp = input.charAt(j);

				if (temp == '(') {
					stick += 1;
					flag = true;
				}
				if (temp == ')') {
					stick -= 1;

					if (flag == true) {
						flag = false;
						part += stick;
					} else {
						part += 1;
					}
				}

			}
			System.out.printf("#%d %d\n", i, part);

		}

	}
}
