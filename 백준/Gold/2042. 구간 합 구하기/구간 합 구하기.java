import java.util.Scanner;

public class Main {
    // 점 갱신, 구간 쿼리
    static long[] tree;
    static int SIZE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        SIZE = 4*N;
        tree = new long[SIZE];

        for(int i=1; i<=N; i++){
            long input = sc.nextLong();
            update(i, input, 1, 1, N);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M+K; i++){
            int a = sc.nextInt();

            if(a == 1){
                int b = sc.nextInt();
                long c = sc.nextLong();
                update(b,c,1,1, N);
            }else{
                int b = sc.nextInt();
                int c = sc.nextInt();

                sb.append(query(b, c, 1, 1, N)).append("\n");
            }
        }
        System.out.println(sb);

    }
    public static void update(int X, long V, int node, int S, int E){
        // 리프노드 일때
        if(S==E){
            tree[node] = V;
            return;
        }

        int mid = (S+E)/2;

        if(X <= mid){
            // 왼쪽
            update(X, V, 2*node, S, mid);
        }else{
            // 오른쪽
            update(X, V, 2*node+1, mid+1, E);
        }

        tree[node] = tree[2*node] + tree[2*node+1];
    }

    public static long query(int L, int R, int node, int S, int E){
        // 구간
        if(R<S || E<L){
            // 속하지 않을때
            return 0;
        }
        if(L<=S && E<=R){
            // 범위안에 모두 있을때
            return tree[node];
        }

        int mid = (S+E)/2;

        // 왼쪽, 오른쪽 리턴값 더하기
        return query(L, R, 2*node, S, mid)
                + query(L, R, 2*node+1, mid+1, E);

    }
}