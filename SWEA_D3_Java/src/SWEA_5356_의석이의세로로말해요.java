import java.util.Scanner;

public class SWEA_5356_의석이의세로로말해요 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			String[] input = new String[5];
			int len = 0;
			for (int j = 0; j < 5; j++) {
				input[j] = sc.next();
				if (len < input[j].length()) {
					len = input[j].length();
				}
			}
			System.out.print("#" + i + " ");

			for (int k = 0; k < len; k++) {
				for (int j = 0; j < 5; j++) {
					if (k < input[j].length()) {
						System.out.print(input[j].charAt(k));
					}

				}

			}
			System.out.println();

		}

	}
}
