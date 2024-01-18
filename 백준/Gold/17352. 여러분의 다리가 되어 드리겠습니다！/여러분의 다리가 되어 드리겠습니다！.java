import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        rank = new int[N+1];

        for(int i=1;i<=N; i++){
            parent[i] = i;
        }

        for(int i=0; i<N-2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }
        Set<Integer> set = new HashSet<>();

        for(int i=1; i<=N; i++){
            set.add(getParent(i));
        }

        Iterator<Integer> it = set.iterator();

        StringBuilder sb = new StringBuilder();
        while(it.hasNext()){
            sb.append(it.next()).append(" ");
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
            parent[aroot] = broot;
            rank[broot]++;

        }else if(rank[aroot]< rank[broot]){
            parent[aroot] = broot;
        }else{
            parent[broot] = aroot;
        }
    }
}