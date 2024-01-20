import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;
    static long div = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        tree = new long[4*N];

        for(int i=1; i<=N; i++){
            long num = Long.parseLong(br.readLine());
            update(i, num, 1, 1, N);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            if(a==1){
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                update(b, c, 1, 1, N);
            }else{
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sb.append(query(b, c, 1, 1, N)).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static void update(int X, long V, int node, int S, int E){
        if(S==E){
            tree[node] = V;
            return;
        }

        int mid = (S+E)/2;

        if(X <= mid){
            update(X, V, 2*node, S, mid);
        }else{
            update(X, V, 2*node+1, mid+1, E);
        }
        tree[node] = (tree[2*node]*tree[2*node+1])%div;
    }
    public static long query(int L, int R, int node, int S, int E){
        if( R<S || E < L){
            return 1;
        }
        if( L<=S && E <=R){
            return tree[node];
        }

        int mid = (S+E)/2;

        return (query(L, R, 2*node, S, mid) * query(L, R, 2*node+1, mid+1, E)) %div;
    }
}