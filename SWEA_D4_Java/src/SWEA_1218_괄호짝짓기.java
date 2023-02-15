import java.util.Scanner;

public class SWEA_1218_괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			int T = sc.nextInt();
			String s = sc.next();

			int flag1 = 0; // {}
			int flag2 = 0; // []
			int flag3 = 0; // ()
			int flag4 = 0; // <>

			int flag5 = 0;
			for (int j = 0; j < T; j++) {
				char temp = s.charAt(j);

				if (temp == '{')
					flag1++;
				else if (temp == '}') {
					if (flag1 > 0) {
						flag1--;

					} else
						flag5++;
				}
				if (temp == '[')
					flag2++;
				else if (temp == ']') {
					if (flag2 > 0) {
						flag2--;

					} else
						flag5++;
				}
				if (temp == '(')
					flag3++;
				else if (temp == ')') {
					if (flag3 > 0) {
						flag3--;

					} else
						flag5++;
				}

				if (temp == '<')
					flag4++;
				else if (temp == '>') {
					if (flag4 > 0) {
						flag4--;

					} else
						flag5++;
				}
			}

			if ((flag1 + flag2 + flag3 + flag4 + flag5) == 0) {
				System.out.printf("#%d 1\n", i);
			} else {
				System.out.printf("#%d 0\n", i);
			}

		}

	}
}
