import java.util.Scanner;

public class SWEA_1928_Base64Decoder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		String input;

		char[] text = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
				'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', '+', '/' };

		String buffer_tobinary = "";

		char[] buffer4 = new char[4];

		char[] buffer8 = new char[8];

		char[] buffer = new char[24];

		for (int i = 1; i <= T; i++) {

			input = sc.next();

			System.out.print("#" + i + " ");
			for (int j = 0; j < input.length(); j += 4) {
				for (int k = 0; k < 4; k++) {
					buffer4[k] = input.charAt(k + j);

					for (int m = 0; m < 64; m++) {
						if (text[m] == buffer4[k]) {
							buffer_tobinary = String.format("%06d", Integer.parseInt(Integer.toBinaryString(m)));

						}
					}

					for (int n = 0; n < 6; n++) {
						buffer[k * 6 + n] = buffer_tobinary.charAt(n);
					}

				}

				for (int o = 0; o < 3; o++) {
					for (int p = 0; p < 8; p++) {
						buffer8[p] = buffer[o * 8 + p];
					}

					String temp;
					int t;
					temp = String.valueOf(buffer8);
					t = Integer.parseInt(temp, 2);

					System.out.print((char) t);
				}

			}

			System.out.println();
		}

	}
}
