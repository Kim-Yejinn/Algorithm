import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc=1; tc<=T; tc++){
            sb.append("Scenario ").append(tc).append(":\n");
            int N = Integer.parseInt(br.readLine());
            parent = new int[N];
            rank = new int[N];

            for(int i=0; i<N; i++){
                parent[i] = i;
            }

            int K = Integer.parseInt(br.readLine());

            for(int i=0; i<K; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                union(u, v);
            }
            int M = Integer.parseInt(br.readLine());
            for(int i=0; i<M; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                int aroot = getParent(a);
                int broot = getParent(b);

                if(aroot == broot){
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static int getParent(int X){
        if(X == parent[X]){
            return X;
        }
        return parent[X] = getParent(parent[X]);
    }
    public static void union(int a, int b){
        int aroot = getParent(a);
        int broot = getParent(b);

        if(aroot == broot){
            return;
        }

        if(rank[aroot] == rank[broot]){
            parent[aroot] = broot;
            rank[broot]++;
        }else if(rank[aroot]<rank[broot]){
            parent[aroot] = broot;
        }else{
            parent[broot] = aroot;
        }

    }
}