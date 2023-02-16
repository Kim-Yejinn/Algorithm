import java.util.Scanner;

public class BOJ_2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int num = sc.nextInt();
			String in = sc.next();

			for (int j = 0; j < in.length(); j++) {
				for (int k = 0; k < num; k++) {
					System.out.print(in.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
