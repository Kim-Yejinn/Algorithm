import java.util.Scanner;

public class SWEA_2043_서랍의비밀번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int P = sc.nextInt();
		int K = sc.nextInt();
		int num = 0;

		for (int k = K; k <= P; k++) {
			num++;
		}
		System.out.println(num);
	}
}
