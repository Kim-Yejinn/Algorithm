import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 전체 수
		int M = sc.nextInt(); // 변경이 일어나는 수
		int K = sc.nextInt(); // 구간의 합을 구함

		long[] arr = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextLong();
		}
		// 세그먼트 트리 생성
		segmentTree st = new segmentTree(N);

		// 입력 배열,현재 노드, root 노드 부터 시작, 마지막 인덱스
		st.init(arr, 1, 1, N);

		for (int i = 0; i < M + K; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			long c = sc.nextLong();

			if (a == 1) {
				// 바꾸기
				st.update(1, 1, N, b, c);

			} else if (a == 2) {
				// 구간 합 구하기
				long result = st.sum(1, 1, N, b, c);
				System.out.println(result);
			}

		}

	}

	static class segmentTree {

		private long[] tree;

		public segmentTree(int num) {
			// 1+2+4+...+2^log2N < 2^log2N+1 < 4N
			this.tree = new long[num * 4];
		}

		long init(long[] arr, int node, int start, int end) {
			// 리프 노드일 경우
			if (start == end) {
				// 배열에 저장 하고 리턴한다.
				return tree[node] = arr[start];
			} else {
				// 리프 노드 아니면 자식 노드 값 더해서 초기화 한다.
				// 왼 : node*2 오 : node*2+1
				// 반으로 나눠서 왼쪽 범위/ 오른쪽 범위
				return tree[node] = init(arr, node * 2, start, (start + end) / 2)
						+ init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
			}

		}

		long sum(int node, int start, int end, int left, long right) {
			if (end < left || right < start) {
				return 0;
			} else if (left <= start && end <= right) {
				return tree[node];
			} else {
				// 일부만 속하거나 모두 포함할 경우
				return sum(node * 2, start, (start + end) / 2, left, right)
						+ sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
			}
		}

		long update(int node, int start, int end, int index, long value) {
			// 만약에 범위가 포함되지 않을 경우 노드 값을 리턴한다.
			if (index < start || end < index) {
				return tree[node];
			} else if (start == index && end == index) {
				// 만약에 구간과 값이 같은경우
				// 바꿀 값을 넣는다.
				return tree[node] = value;
			} else {
				// 자식 노드 더한다.
				return tree[node] = update(node * 2, start, (start + end) / 2, index, value)
						+ update(node * 2 + 1, (start + end) / 2 + 1, end, index, value);

			}

		}

	}

}