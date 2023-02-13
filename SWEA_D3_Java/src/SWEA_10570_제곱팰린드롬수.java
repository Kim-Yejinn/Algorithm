import java.util.Scanner;

public class SWEA_10570_제곱팰린드롬수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int A=sc.nextInt();
			int B=sc.nextInt();
			
			
			System.out.println((int)Math.sqrt(A));
			
			System.out.println((int)Math.sqrt(B));
			
		}
	}
}
