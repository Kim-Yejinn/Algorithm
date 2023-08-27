import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int N;
	static int[] c;
	static Queue<Integer> q = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		arr = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			arr[a][b] = arr[b][a] = 1;
		}
		c = new int[N + 1];
		dfs(V);
		System.out.println();
		c = new int[N + 1];
		bfs(V);

	}

	public static void dfs(int num) {
		if (c[num] == 1)
			return;
		c[num] = 1;
		System.out.print(num + " ");
		for (int i = 1; i < arr[num].length; i++) {
			if (arr[num][i] == 1) {
				dfs(i);
			}
		}
	}

	public static void bfs(int num) {
		q.add(num);
		c[num] = 1;

		while (!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x + " ");
			for (int i = 1; i < arr[x].length; i++) {
				if (c[i] == 0 && arr[x][i] == 1) {
					q.add(i);
					c[i] = 1;
				}
			}
		}
	}

}