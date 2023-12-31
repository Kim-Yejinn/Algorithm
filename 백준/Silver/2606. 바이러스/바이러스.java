import java.util.Scanner;

public class Main {
	// dfs 써볼까..

	// 방문 확인
	static int[] c;
	// 노드 개수
	static int N;
	static int Edge;

	// 연결..
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		Edge = sc.nextInt();

		// 숫자로 쓸꺼니까 +1
		arr = new int[N + 1][N + 1];
		// 방문 확인할것도 숫자로 쓸거임
		c = new int[N + 1];

		for (int i = 0; i < Edge; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			arr[a][b] = arr[b][a] = 1;
		}

		// 1번 컴퓨터 부터 가자..
		dfs(1);
		// c에서 방문처리 된거가 바이러스 걸린 개수일듯
		// 카운트하자
		int cnt = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 1) {
				cnt++;
			}
		}
		// 출력
		// 근데 1번 컴퓨터는 이미 감염임
		// 따라서 1빼줘야됨
		System.out.println(cnt - 1);

	}

	// 재귀함수로 하자..
	public static void dfs(int num) {
		// 만약 방문했으면 그냥 리턴
		if (c[num] == 1)
			return;
		// 방문을 안했다?
		// 방문 표시 하구
		c[num] = 1;

		// 근처를 가보자
		// 해당 노드일때 갈수 있는건 그 숫자의 배열 크기
		// 숫자니까 1부터
		for (int i = 1; i < arr[num].length; i++) {
			// 만약 연결 안되었으면 ㄴㄴ
			if (arr[num][i] == 0)
				continue;

			// 연결 되었으면 가자
			dfs(i);
		}
	}

}