import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;
    static long[] lazy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        tree = new long[4*N];
        lazy = new long[4*N];

        for(int i=1; i<=N; i++){
            long num = Long.parseLong(br.readLine());
            init(i, num, 1, 1, N);
        }

        for(int i=1; i<=M+K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            if(a == 1){
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long d = Long.parseLong(st.nextToken());
                update(b, c, d, 1, 1, N);
            }else{
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sb.append(query(b, c, 1, 1, N)).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static void init(int X, long V, int node, int S, int E){
        if(S == E){
            tree[node] = V;
            return;
        }

        int mid = (S+E)/2;

        if(X <= mid){
            init(X, V, 2*node, S, mid);
        }else{
            init(X, V, 2*node+1, mid+1, E);
        }
        tree[node] = tree[2*node] + tree[2*node+1];
    }
    public static void update(int L, int R, long V, int node, int S, int E){
        if( R < S || E < L){
            return;
        }
        if( L<= S && E <= R){
            tree[node] += (E-S+1) * V;
            lazy[node] += V;
            return;
        }

        propagate(node, S, E);

        int mid = (S+E)/2;

        update(L, R, V, 2*node, S, mid);
        update(L, R, V, 2*node+1, mid+1, E);

        tree[node] = tree[2*node] + tree[2*node+1];
    }
    public static void propagate(int node, int S, int E){
        int mid = (S+E)/2;

        // 왼쪽
        tree[2*node] += (mid-S+1) * lazy[node];
        lazy[2*node] += lazy[node];
        // 오른쪽
        tree[2*node+1] += (E-mid) * lazy[node];
        lazy[2*node+1] += lazy[node];

        lazy[node] = 0;
    }
    public static long query(int L, int R, int node, int S, int E){
        if( R< S || E < L){
            return 0;
        }
        if( L <= S && E <= R){
            return tree[node];
        }

        propagate(node, S, E);

        int mid = (S+E)/2;

        return query(L, R, 2*node, S, mid) + query(L, R, 2*node+1, mid+1, E);
    }
}