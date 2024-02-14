import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] tree;
    static int[] lazy;
    static int N;

    public static void propagate(int node, int S, int E){
        if(lazy[node] == 0){
            return;
        }

        int mid = (S+E) / 2;

        // lazy
        lazy[2*node] ^= lazy[node];
        lazy[2*node+1] ^= lazy[node];

        // tree
        tree[2*node] = (mid - S + 1) - tree[2*node];
        tree[2*node+1] = (E-mid) - tree[2*node+1];

        lazy[node] = 0;
    }
    public static void update(int L, int R, int node, int S, int E){
        if( E < L || R < S){
            return;
        }

        if(L <= S && E <= R ){
            lazy[node] ^= 1;
            tree[node] = (E-S + 1) - tree[node];
            return;
        }

        propagate(node, S, E);

        int mid = (S+E) /2;

        update(L, R, 2*node, S, mid);
        update(L, R, 2*node+1, mid+1, E);

        tree[node] = tree[2*node] + tree[2*node+1];
    }

    public static int query(int L, int R, int node, int S, int E){
        if( E < L || R < S){
            return 0;
        }

        if(L <= S && E <= R ){
            return tree[node];
        }

        propagate(node, S, E);

        int mid = (S+E)/2;
        return query(L, R, 2*node, S, mid) + query(L, R, 2*node+1, mid+1, E);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new int[N*4];
        lazy = new int[N*4];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());

            if(op == 0){
                int s = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                update(s, t, 1, 1, N);
            }else{
                int s = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                sb.append(query(s, t, 1, 1, N)).append("\n");
            }
        }
        System.out.println(sb);
    }
}