import java.util.Scanner;

public class BOJ_2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] A = sc.next().toCharArray();
		char[] B = sc.next().toCharArray();

		reverse(A);
		reverse(B);

		for (int i = 0; i < A.length; i++) {
			if (A[i] > B[i]) {
				for (int j = 0; j < A.length; j++)
					System.out.print(A[j]);
				break;
			} else if (A[i] < B[i]) {
				for (int j = 0; j < B.length; j++)
					System.out.print(B[j]);
				break;
			}

		}

	}

	static char[] reverse(char[] num) {
		for (int i = 0; i < num.length / 2; i++) {
			char temp = num[i];
			num[i] = num[num.length - 1 - i];
			num[num.length - 1 - i] = temp;
		}
		return num;

	}

}
