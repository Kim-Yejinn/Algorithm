import java.util.Scanner;

public class BOJ_2480 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int cnt = 0;

		if (A == B && B == C)
			System.out.println(10000 + A * 1000);
		else if (A == B)
			System.out.println(1000 + A * 100);
		else if (B == C)
			System.out.println(1000 + B * 100);
		else if (C == A)
			System.out.println(1000 + A * 100);
		else
			System.out.println((A > B ? (A > C ? A : C) : (B > C ? B : C)) * 100);

	}
}
