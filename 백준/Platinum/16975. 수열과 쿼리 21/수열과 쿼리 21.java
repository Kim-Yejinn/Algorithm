import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 구간 갱신, 점 쿼리, lazy

    static long[] tree;
    static long[] lazy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new long[4*N];
        lazy = new long[4*N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++){
            long num = Long.parseLong(st.nextToken());
            init(i, num, 1,1, N);
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());
            if(op==1){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                long v = Long.parseLong(st.nextToken());
                update(a, b, v, 1, 1, N);
            }else{
                int a = Integer.parseInt(st.nextToken());
                sb.append(query(a, 1, 1, N)).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static void init(int X, long V, int node, int S, int E){
        if(S==E){
            tree[node] = V;
            return;
        }
        int mid = (S+E)/2;
        if(X<=mid){
            init(X, V, 2*node, S, mid);
        }else{
            init(X, V, 2*node+1, mid+1, E);
        }
        tree[node] = tree[2*node]+tree[2*node+1];
    }
    public static void propagate(int node, int S, int E){
        int mid = (S+E)/2;
        // 왼쪽
        // 개수 * lazy값
        tree[2*node] += (mid-S+1) * lazy[node];
        lazy[2*node] += lazy[node];
        // 오른쪽
        tree[2*node+1] += (E-mid) * lazy[node];
        lazy[2*node+1] += lazy[node];

        lazy[node] = 0;
    }

    public static void update(int L, int R, long V, int node, int S, int E){
        if( R<S || E< L){
            return;
        }
        if( L<= S && E<= R){
            // 범위 안이라면..
            // 해당 범위 양 만큼 트리에 넣자
            tree[node] += (E - S + 1) * V;
            lazy[node] += V;
            return;
        }

        propagate(node, S, E);

        int mid = (S+E)/2;

        update(L, R, V, 2*node, S, mid);
        update(L, R, V, 2*node+1, mid+1, E);

        tree[node] = tree[2*node]+tree[2*node+1];
    }

    public static long query(int X, int node, int S, int E){
        if(S==E){
            return tree[node];
        }

        propagate(node, S, E);
        int mid = (S+E)/2;

        if(X <= mid){
            return query(X, 2*node, S, mid);
        }else{
            return query(X, 2*node+1, mid+1, E);
        }
    }
}