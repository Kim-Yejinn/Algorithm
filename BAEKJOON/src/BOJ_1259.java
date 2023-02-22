import java.util.Scanner;

public class BOJ_1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			char[] N = sc.next().toCharArray();
			if (N[0] == '0') {
				break;
			}

			if (pal(N) == true) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

		}

	}

	static boolean pal(char[] num) {
		for (int i = 0; i < num.length / 2; i++) {
			if (num[i] != num[num.length - 1 - i]) {
				return false;
			}
		}
		return true;
	}
}
