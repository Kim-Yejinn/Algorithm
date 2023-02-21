import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1223_계산기2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {

			int T = sc.nextInt();
			Stack<Character> op = new Stack<>();

			char[] arr = sc.next().toCharArray();
			char[] change = new char[T];
			int cnt = 0;

			for (int j = 0; j < arr.length; j++) {
				if (arr[j] >= '0' && arr[j] <= '9') {
					change[cnt++] = arr[j];
				} else if (arr[j] == '*') {
					if (op.isEmpty() || op.peek() == '+') {
						op.push('*');
					} else if (op.peek() == '*') {
						change[cnt++] = '*';
					}
				} else if (arr[j] == '+') {
					if (op.empty()) {
						op.push('+');
					} else {
						while (!op.isEmpty()) {
							char n = op.pop();
							change[cnt++] = n;
						}
						op.push('+');
					}
				}

				if (j == arr.length - 1) {
					while (!op.isEmpty()) {
						char n = op.pop();
						change[cnt++] = n;
					}

				}
			}

			Stack<Integer> num = new Stack<>();

			for (int j = 0; j < change.length; j++) {
				if (change[j] >= '0' && change[j] <= '9') {
					num.push(change[j] - '0');

				} else if (change[j] == '*') {
					if (!num.isEmpty()) {
						int a = num.pop();
						int b = num.pop();
						num.push(a * b);
					}

				} else if (change[j] == '+') {
					if (!num.isEmpty()) {
						int a = num.pop();
						int b = num.pop();
						num.push(a + b);
					}
				}

			}
			System.out.printf("#%d %d\n", i, num.pop());

		}

	}
}
