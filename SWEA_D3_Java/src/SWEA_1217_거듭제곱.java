import java.util.Scanner;

public class SWEA_1217_거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i < 11; i++) {
			int T=sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			int result = 1;

			for (int j = 0; j < b; j++) {
				result = mul(result, a);
			}
			System.out.println("#"+T+" "+result);

		}
	}

	static int mul(int result, int num) {
		return result * num;
	}

}
