import java.util.Scanner;

public class SWEA_2070_큰놈작은놈같은놈 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (a - b > 0) {
				System.out.println("#" + i + " >");
			} else if (a == b) {
				System.out.println("#" + i + " =");
			} else {
				System.out.println("#" + i + " <");
			}
		}

	}
}
