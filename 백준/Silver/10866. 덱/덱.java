
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static Node front;
	public static Node rear;
	public static int size = 0;

	public static class Node {
		int data;
		Node preLink;
		Node nextLink;

		public Node(int data) {
			super();
			this.data = data;
		}
	}

	// 비어있는지 확인
	public static int empty() {
		if (front == null) {
			return 1;
		} else {
			return 0;
		}
	}

	// 앞에 추가
	public static void push_front(int x) {
		Node node = new Node(x);
		if (empty() == 1) {
			front = node;
			rear = node;
			node.preLink = null;
			node.nextLink = null;
		} else {
			front.preLink = node;
			node.nextLink = front;
			node.preLink = null;
			front = node;
		}
		size++;
	}

	// 뒤에 추가
	public static void push_back(int x) {
		Node node = new Node(x);
		if (empty() == 1) {
			front = node;
			rear = node;
			node.preLink = null;
			node.nextLink = null;
		} else {
			rear.nextLink = node;
			node.preLink = rear;
			node.nextLink = null;
			rear = node;
		}
		size++;
	}

	// 앞에 빼고 리턴
	public static int pop_front() {
		if (empty() == 1) {
			return -1;
		} else {
			size--;
			int data = front.data;
			if (front.nextLink == null) {
				front = null;
				rear = null;
			} else {
				front = front.nextLink;
				front.preLink = null;
			}
			return data;
		}
	}

	// 뒤에 빼고 리턴
	public static int pop_back() {
		if (empty() == 1) {
			return -1;
		} else {
			size--;
			int data = rear.data;
			if (rear.preLink == null) {
				front = null;
				rear = null;
			} else {
				rear = rear.preLink;
				rear.nextLink = null;
			}
			return data;
		}
	}

	// 덱 사이즈
	public static int size() {
		return size;
	}

	// 앞에 정수 리턴
	public static int front() {
		if (empty() == 1) {
			return -1;
		} else {
			return front.data;
		}
	}

	// 뒤에 정수 리턴
	public static int back() {
		if (empty() == 1) {
			return -1;
		} else {
			return rear.data;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tk;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(br.readLine());
			String op = tk.nextToken();
			switch (op) {
			case "push_front":
				int x = Integer.parseInt(tk.nextToken());
				push_front(x);
				break;
			case "push_back":
				int y = Integer.parseInt(tk.nextToken());
				push_back(y);
				break;

			case "pop_front":

				sb.append(pop_front()).append("\n");
				break;

			case "pop_back":
				sb.append(pop_back()).append("\n");
				break;

			case "size":
				sb.append(size()).append("\n");
				break;

			case "empty":
				sb.append(empty()).append("\n");
				break;

			case "front":
				sb.append(front()).append("\n");
				break;

			case "back":
				sb.append(back()).append("\n");
				break;

			}

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
}
