import java.util.Scanner;

public class SWEA_8931_제로 {
	static int[] arr = new int[100010];
	static int top = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int K = sc.nextInt();

			for (int j = 0; j < K; j++) {
				int temp = sc.nextInt();
				if (temp == 0) {
					pop();
				} else {
					push(temp);
				}
			}

			System.out.printf("#%d %d\n", i, sum());

		}

	}

	static void push(int num) {

		if (top == arr.length - 1) {
			System.out.println("오버플로우임");
		} else {
			arr[++top] = num;
		}

	}

	static int pop() {

		if (top == -1) {
			System.out.println("값없음");
			return -1;
		} else {
			return arr[top--];

		}

	}

	static long sum() {
		int temp = 0;

		for (int i = 0; i <= top; i++) {
			temp += arr[i];
		}

		top = -1;
		return temp;

	}

}
