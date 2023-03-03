import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1197 {
	static int V, E, parents[];
	static Edge[] edgeList;

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {

			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();
		edgeList = new Edge[E];
		for (int i = 0; i < E; i++) {
			edgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(edgeList);

		parents = new int[V];

		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
		int sum = 0;
		for (int i = 0; i < edgeList.length; i++) {
			if (!find(parents, edgeList[i].start - 1, edgeList[i].end - 1)) {
				union(parents, edgeList[i].start - 1, edgeList[i].end - 1);
				sum += edgeList[i].weight;
			}
		}
System.out.println(Arrays.toString(parents));
		System.out.println(sum);

	}

	// 부모 데리고 옴
	public static int getParents(int[] parents, int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = getParents(parents, parents[x]);
	}

	// 부모 합침
	public static void union(int[] parents, int a, int b) {
		int aroot = getParents(parents, a);
		int broot = getParents(parents, b);
		if (aroot < broot)
			parents[b] = aroot;
		else
			parents[a] = broot;
	}

	// 같은 부모 확인
	public static boolean find(int[] parents, int a, int b) {
		int aroot = getParents(parents, a);
		int broot = getParents(parents, b);
		if (aroot == broot)
			return true;
		else
			return false;
	}

}
