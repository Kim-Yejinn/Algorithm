import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 점 갱신, 구간 쿼리
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new int[4*N];
        Arrays.fill(tree, Integer.MAX_VALUE);

        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(br.readLine());
            update(i, num, 1, 1, N);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(query(a, b, 1, 1, N)).append("\n");
        }
        System.out.println(sb);
    }
    public static void update(int X, int V, int node, int S, int E){
        // 리프노드
        if(S==E){
            tree[node] = V;
            return;
        }
        // 아닐때는 아래로
        int mid = (S+E)/2;

        if(X <= mid){
            // 왼쪽
            update(X, V, 2*node, S, mid);
        }else{
            update(X, V, 2*node+1, mid+1, E);
        }
        // 작은 것으로 갱신하자
        tree[node] = Math.min(tree[2*node], tree[2*node+1]);
    }

    public static int query(int L, int R, int node, int S, int E){
        // 범위안이 아닐때
        if( R<S || E<L){
            return Integer.MAX_VALUE;
        }
        // 범위안에 모두 들어갈때
        if( L<=S && E<=R){
            return tree[node];
        }

        // 일부만 들어갈때
        int mid = (S+E)/2;
        return Math.min(query(L, R, 2*node, S, mid), query(L, R, 2*node+1, mid+1, E));
    }
}