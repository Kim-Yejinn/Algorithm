
import java.util.Scanner;

public class Main {
	// 1 - 상근
	// 2 - 창영
	// 3 - 상근
	// 4 - 창영
	// 5 - 상근
	// 6 - 창영
	// 7 - 상근

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N % 2 == 0) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}
}
