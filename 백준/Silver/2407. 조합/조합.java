import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;

		for (int i = n; i > n - m; i--) {
			a = a.multiply(BigInteger.valueOf(i));
		}

		for (int i = 1; i <= m; i++) {
			b = b.multiply(BigInteger.valueOf(i));
		}

		System.out.println(a.divide(b));

	}

}