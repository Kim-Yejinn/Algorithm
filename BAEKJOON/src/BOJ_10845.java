import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10845 {
	public static int n = 10001;
	public static int[] q = new int[n];
	public static int front = -1;
	public static int rear = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {

			String[] arr = br.readLine().split(" ");

			if (arr[0].equals("push")) {
				push(Integer.parseInt(arr[1]));
			} else if (arr[0].equals("pop")) {
				System.out.println(pop());
			} else if (arr[0].equals("size")) {
				System.out.println(size());
			} else if (arr[0].equals("empty")) {
				System.out.println(empty());
			} else if (arr[0].equals("front")) {
				System.out.println(front());
			} else if (arr[0].equals("back")) {
				System.out.println(back());
			}
		}

	}

	public static void push(int X) {
		if (rear == n - 1) {
		} else {
			q[++rear] = X;
		}
	}

	public static int pop() {
		if (empty() == 1) {
			return -1;
		} else {
			return q[++front];
		}
	}

	public static int size() {
		return rear - front;
	}

	public static int empty() {
		if (rear == front) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int front() {
		if (empty() == 1) {
			return -1;
		} else {
			return q[front + 1];
		}
	}

	public static int back() {
		if (empty() == 1) {
			return -1;
		} else {
			return q[rear];
		}
	}
}
