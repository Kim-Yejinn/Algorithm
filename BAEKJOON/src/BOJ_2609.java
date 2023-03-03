import java.util.Scanner;

public class BOJ_2609 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		int div = div(A, B);

		int mul = A * B / div;

		System.out.println(div);
		System.out.println(mul);

	}

	public static int div(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}

		if (b == 0) {
			return a;
		} else {
			return div(b, a % b);
		}

	}
}
