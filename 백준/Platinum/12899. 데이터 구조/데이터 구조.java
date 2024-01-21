import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] tree;
    static Map<Integer, Integer> map;
    static int MAX = 2_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new int[4*MAX];
        map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(A==1){
                update(B, 1, 1, MAX);
            }else{
                sb.append(query(B, 1, 1, MAX)).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static void update(int X, int node, int S, int E){
        if(S==E){
            map.put(node, X);
            tree[node]++;
            return;
        }

        int mid = (S+E)/2;

        if(X<= mid){
            update(X, 2*node, S, mid);
        }else{
            update(X, 2*node+1, mid+1, E);
        }
        tree[node] = tree[2*node]+tree[2*node+1];
    }

    public static int query(int X, int node, int S, int E){
        if(S==E){
            tree[node]--;
            return map.get(node);
        }
        int mid = (S+E)/2;
        tree[node]--;
        if(X <= tree[2*node]){
            return query(X, 2*node, S, mid);
        }else{
            return query(X-tree[2*node], 2*node+1, mid+1, E);
        }
    }
}