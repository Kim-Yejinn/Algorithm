import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] count;
    static int[] rank;

    static int MAX = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        parent = new int[MAX+1];
        count = new int[MAX+1];
        rank = new int[MAX+1];

        for(int i=1; i<=MAX; i++){
            parent[i] = i;
            count[i] = 1;
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            char op = st.nextToken().charAt(0);

            if(op == 'I'){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }else{
                int num = Integer.parseInt(st.nextToken());
                sb.append(count[getParent(num)]).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static int getParent(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = getParent(parent[x]);
    }

    public static void union(int a, int b){
        int aroot = getParent(a);
        int broot = getParent(b);

        if(aroot == broot){
            return;
        }

        if(rank[aroot] == rank[broot]){
            // 아무곳
            parent[aroot] = broot;
            rank[broot]++;
            count[broot] += count[aroot];
        }else if(rank[aroot] < rank[broot]){
            parent[aroot] = broot;
            count[broot] += count[aroot];
        }else{
            parent[broot] = aroot;
            count[aroot] += count[broot];
        }
    }
}