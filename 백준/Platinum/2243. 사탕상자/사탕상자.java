import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] tree;
    static int TASTE = 1_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new int[4*TASTE];

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());

            if(A==1){
                // 사탕 꺼내기
                int B = Integer.parseInt(st.nextToken());
                sb.append(query(B, 1, 1, TASTE)).append("\n");
            }else{
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                update(B, C, 1, 1, TASTE);
            }
        }
        System.out.println(sb);

    }
    public static void update(int X, int V, int node, int S, int E){
        // 사탕 넣기
        if(S==E){
            tree[node] += V;
            return;
        }

        int mid = (S+E)/2;

        if(X<=mid){
            update(X, V, 2*node, S, mid);
        }else{
            update(X, V, 2*node+1, mid+1, E);
        }
        tree[node] = tree[2*node]+tree[2*node+1];
    }
    public static int query(int X, int node, int S, int E){
        // X 번째 사탕 꺼내기
        if(S==E){
            tree[node]--;
            return S;
        }

        int mid = (S+E)/2;
        tree[node]--;
        if(X<=tree[2*node]){
            // 왼쪽
            return query(X, 2*node, S, mid);
        }else {
            // 오른쪽
            return query(X-tree[2*node], 2*node+1, mid+1, E);
        }

    }
}