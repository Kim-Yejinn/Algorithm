import java.util.Scanner;

public class SWEA_4406_모음이보이지않는사람 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {

			String input = sc.next();

			char[] aeiou = { 'a', 'e', 'i', 'o', 'u' };
			System.out.print("#" + i + " ");
			for (int j = 0; j < input.length(); j++) {
				int flag = 0;
				for (int k = 0; k < 5; k++) {
					if (input.charAt(j) == aeiou[k]) {
						flag = 1;
					}

				}
				if (flag == 0) {
					System.out.print(input.charAt(j));

				}
			}
			System.out.println();

		}

	}
}
