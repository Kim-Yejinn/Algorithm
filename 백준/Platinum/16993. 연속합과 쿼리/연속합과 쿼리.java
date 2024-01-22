import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        long prefix; // 맨앞 포함 최대
        long suffix; // 맨뒤 포함 최대
        long maxSum; // 그냥 전체 최대
        long sum; // 전체 합
        Node(){
            this.prefix = Integer.MIN_VALUE;
            this.suffix = Integer.MIN_VALUE;
            this.maxSum = Integer.MIN_VALUE;
            this.sum = Integer.MIN_VALUE;
        }
        Node(long prefix, long suffix, long maxSum, long sum){
            this.prefix = prefix;
            this.suffix = suffix;
            this.maxSum = maxSum;
            this.sum = sum;
        }
    }

    static Node[] tree;
    static int INFL = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new Node[4*N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(st.nextToken());
            update(i, num, 1, 1, N);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(query(a, b, 1, 1, N).maxSum).append("\n");
        }

        System.out.println(sb);

    }
    public static Node update(int X, int V, int node, int S, int E){

        // 초기화 해주어야 한다!!
        if(X < S || X > E ){
            if(tree[node] == null){
                return tree[node] = new Node(0,0,0,0);
            }else{
                return tree[node];
            }
        }
        // 여기까지

        if(S==E){
            if(S == X){
                return tree[node] = new Node(V, V, V, V);
            }else{
                return new Node();
            }
        }

        int mid = (S+E)/2;

        Node left = update(X, V, 2*node, S, mid);
        Node right = update(X, V, 2*node+1, mid+1, E);

        long prefix = left.sum + right.prefix;
        prefix = Math.max(prefix, left.prefix);

        long suffix =left.suffix + right.sum;
        suffix = Math.max(suffix, right.suffix);

        long maxSum = Math.max(left.maxSum, right.maxSum);
        maxSum = Math.max(maxSum, left.suffix+right.prefix);

        long sum = left.sum + right.sum;

        return tree[node] = new Node(prefix,suffix, maxSum, sum);
    }
    public static Node query(int L, int R, int node, int S, int E){

        if( R < S || E < L){
            if(tree[node] == null){
                return tree[node] = new Node();
            }else{
                return new Node();
            }
        }
        if( L<=S && E<=R){
            return tree[node];
        }

        int mid = (S+E)/2;

        Node left = query(L, R, 2*node, S, mid);
        Node right = query(L, R, 2*node+1, mid+1, E);

        long prefix = left.sum + right.prefix;
        prefix = Math.max(prefix, left.prefix);
        long suffix =left.suffix + right.sum;
        suffix = Math.max(suffix, right.suffix);
        long maxSum = Math.max(left.maxSum, right.maxSum);
        maxSum = Math.max(maxSum, left.suffix+right.prefix);
        long sum = left.sum + right.sum;

        return new Node(prefix, suffix, maxSum, sum);

    }
}