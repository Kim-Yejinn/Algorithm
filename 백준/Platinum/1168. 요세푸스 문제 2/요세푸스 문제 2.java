import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] tree;
    static int MAX = 100_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        tree = new int[4*MAX];
        for(int i=1; i<=N; i++){
            update(i, 1, 1, MAX);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = K;
        for(int i=0; i<N-1; i++){
            sb.append(query(idx, 1, 1, MAX));
            idx = (idx+K-2) % tree[1] +1 ;
            sb.append(", ");
        }
        sb.append(query(idx, 1, 1, MAX)).append(">");
        System.out.println(sb);

    }
    public static void update(int X, int node, int S, int E){
        if(S == E){
            tree[node] = 1;
            return;
        }
        int mid = (S+E)/2;

        if(X<=mid){
            update(X, 2*node, S, mid);
        }else{
            update(X, 2*node+1, mid+1, E);
        }
        tree[node] = tree[2*node]+tree[2*node+1];
    }
    public static int query(int X, int node, int S, int E){
        if(S==E){
            tree[node]--;
            return S;
        }

        int mid = (S+E)/2;

        tree[node]--;
        if(X <= tree[2*node]){
            return query(X, 2*node, S, mid);
        }else{
            return query(X- tree[2*node], 2*node+1, mid+1, E);
        }

    }
}