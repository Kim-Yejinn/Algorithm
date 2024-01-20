import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] minTree;
    static int[] maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        minTree = new int[4*N];
        maxTree = new int[4*N];

        Arrays.fill(minTree, Integer.MAX_VALUE);
        Arrays.fill(maxTree, Integer.MIN_VALUE);

        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(br.readLine());
            update(i, num, 1, 1, N);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(queryMin(a, b, 1, 1, N)).append(" ").append(queryMax(a, b, 1, 1, N)).append("\n");
        }
        System.out.println(sb);
    }
    public static void update(int X, int V, int node, int S, int E){
        // 리프노드
        if(S==E){
            minTree[node] = V;
            maxTree[node] = V;
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
        minTree[node] = Math.min(minTree[2*node], minTree[2*node+1]);
        maxTree[node] = Math.max(maxTree[2*node], maxTree[2*node+1]);

    }
    public static int queryMin(int L, int R, int node, int S, int E){
        // 범위안이 아닐때
        if( R<S || E<L){
            return Integer.MAX_VALUE;
        }
        // 범위안에 모두 들어갈때
        if( L<=S && E<=R){
            return minTree[node];
        }

        // 일부만 들어갈때
        int mid = (S+E)/2;
        return Math.min(queryMin(L, R, 2*node, S, mid), queryMin(L, R, 2*node+1, mid+1, E));
    }
    public static int queryMax(int L, int R, int node, int S, int E){
        // 범위안이 아닐때
        if( R<S || E<L){
            return Integer.MIN_VALUE;
        }
        // 범위안에 모두 들어갈때
        if( L<=S && E<=R){
            return maxTree[node];
        }

        // 일부만 들어갈때
        int mid = (S+E)/2;
        return Math.max(queryMax(L, R, 2*node, S, mid), queryMax(L, R, 2*node+1, mid+1, E));
    }
}