import java.util.Scanner;

public class SWEA_1216_회문2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[][] arr = new char[100][100];

		for (int i = 1; i < 11; i++) {

			int T = sc.nextInt();
			int max = 0;

			for (int r = 0; r < 100; r++) {
				String temp = sc.next();

				for (int c = 0; c < 100; c++) {
					arr[r][c] = temp.charAt(c);

				}
			}

			for (int t = 2; t < 100; t++) {
				for (int r = 0; r < 100; r++) {
					for (int c = 0; c < 100; c++) {

						String temp_c = "";
						String temp_r = "";
						for (int j = 0; j < t; j++) {
							if (c + j < 100) {
								temp_c += Character.toString(arr[r][c + j]);
								temp_r += Character.toString(arr[c + j][r]);
							}else {
								break;
								
							}
						}
						if (pal(temp_c) || pal(temp_r)) {
							if (max < t) {
								max = t;
							}
						}

					}

				}
			}
			System.out.printf("#%d %d\n", i, max);

		}
	}

	static boolean pal(String str) {
		boolean status = true;
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				status = false;
				break;
			}
		}
		return status;

	}
}
