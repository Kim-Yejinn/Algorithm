import java.util.Scanner;

public class BOJ_25304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		int n = sc.nextInt();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += sc.nextInt() * sc.nextInt();
		}
		if (sum == X) {
			System.out.println("Yes");
		} else
			System.out.println("No");
	}
}
