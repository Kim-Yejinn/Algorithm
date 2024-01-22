import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        tree = new long[4*N];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            update(i, Integer.parseInt(st.nextToken()), 1, 1, N);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(y<x){
                int t = x;
                x = y;
                y = t;
            }
            sb.append(query(x, y, 1, 1, N)).append("\n");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            update(a, b, 1, 1, N);
        }
        System.out.println(sb);

    }
    public static void update(int X, int V, int node, int S, int E){
        if(S==E){
            tree[node] = V;
            return;
        }

        int mid = (S+E)/2;

        if(X<=mid){
            update(X, V, 2*node, S, mid);
        }else{
            update(X, V, 2*node+1, mid+1, E);
        }
        tree[node] = tree[2*node] + tree[2*node+1];
    }
    public static long query(int L, int R, int node, int S, int E){
        if( R < S || E < L){
            return 0;
        }
        if( L <= S && E <=R){
            return tree[node];
        }
        int mid = (S+E)/2;

        return query(L, R, 2*node, S, mid) + query(L, R, 2*node+1, mid+1, E);

    }
}