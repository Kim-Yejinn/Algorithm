import java.util.Scanner;

public class SWEA_3499_퍼펙트셔플2 {
	public static int n = 600;
	public static String[] arr = new String[n];
	public static int front = -1, rear = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();

			System.out.print("#" + i);
			for (int j = 0; j < N; j++) {
				String temp = sc.next();
				if (N % 2 == 0) {
					if (j < N / 2) {
						enQueue(temp);
					} else {
						System.out.print(" " + deQueue() + " " + temp);
					}

				} else {
					if (j <= N / 2) {
						enQueue(temp);
					} else {
						System.out.print(" " + deQueue() + " " + temp);
						if (j == N - 1) {
							System.out.print(" " + deQueue());
						}
					}
				}
			}
			front = -1;
			rear = -1;
			System.out.println();
		}
	}

	public static void enQueue(String str) {
		if (rear != n - 1)
			arr[++rear] = str;
	}

	public static String deQueue() {
		if (front == rear) {
			return "";
		} else {
			return arr[++front];
		}
	}

}
