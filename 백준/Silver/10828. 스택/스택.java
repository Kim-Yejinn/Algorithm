import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] arr;
	static int top = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			String[] com = br.readLine().split(" ");

			if (com[0].equals("push")) {
				push(Integer.parseInt(com[1]));
			}
			if (com[0].equals("pop")) {
				System.out.println(pop());
			}
			if (com[0].equals("size")) {
				System.out.println(size());
			}
			if (com[0].equals("empty")) {
				System.out.println(empty());
			}
			if (com[0].equals("top")) {
				System.out.println(top());
			}
		}
	}

	public static void push(int num) {
		arr[++top] = num;
	}

	public static int pop() {
		if (empty() == 1) {
			return -1;
		} else {
			return arr[top--];
		}
	}

	public static int size() {
		return top + 1;
	}

	public static int empty() {
		if (top == -1) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int top() {
		if (empty() == 1) {
			return -1;
		} else {
			return arr[top];
		}
	}
}
