import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] minTree;
    static int[] maxTree;
    static int[] DVD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            minTree = new int[4*N];
            maxTree = new int[4*N];
            DVD = new int[N+1];

            Arrays.fill(minTree, Integer.MAX_VALUE);
            Arrays.fill(maxTree, Integer.MIN_VALUE);

            for(int i=1; i<=N; i++){
                update(i, i, 1, 1, N);
                DVD[i] = i;
            }

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());

                int Q = Integer.parseInt(st.nextToken());
                int A = Integer.parseInt(st.nextToken())+1;
                int B = Integer.parseInt(st.nextToken())+1;

                if(Q==0){
                    int t = DVD[A];
                    DVD[A] = DVD[B];
                    DVD[B] = t;

                    update(A, DVD[A], 1, 1, N);
                    update(B, DVD[B], 1, 1, N);

                }else{
                    int min = queryMin(A, B, 1, 1, N);
                    int max = queryMax(A, B, 1, 1, N);

                    if(min == A && max == B){
                        sb.append("YES").append("\n");
                    }else{
                        sb.append("NO").append("\n");
                    }
                }
            }

        }
        System.out.println(sb);


    }
    public static void update(int X, int V, int node, int S, int E){
        if(S==E){
            minTree[node] = V;
            maxTree[node] = V;
            return;
        }

        int mid = (S+E)/2;

        if( X<=mid ){
            update(X, V, 2*node, S, mid);
        }else{
            update(X, V, 2*node+1, mid+1, E);
        }
        minTree[node] = Math.min(minTree[2*node], minTree[2*node+1]);
        maxTree[node] = Math.max(maxTree[2*node], maxTree[2*node+1]);
    }

    public static int queryMin(int L, int R, int node, int S, int E){
        if( R<S || E<L){
            return Integer.MAX_VALUE;
        }
        if( L<=S && E<=R){
            return minTree[node];
        }

        int mid = (S+E)/2;
        return Math.min(queryMin(L, R, 2*node, S, mid),
                queryMin(L, R, 2*node+1, mid+1, E));
    }
    public static int queryMax(int L, int R, int node, int S, int E){
        if( R<S || E<L){
            return Integer.MIN_VALUE;
        }
        if( L<=S && E<=R){
            return maxTree[node];
        }

        int mid = (S+E)/2;
        return Math.max(queryMax(L, R, 2*node, S, mid),
                queryMax(L, R, 2*node+1, mid+1, E));
    }
}