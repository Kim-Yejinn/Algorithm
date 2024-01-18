import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        rank = new int[N+1];

        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        int cnt = 0;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(isFamily(a, b)){
                cnt++;
            }else{
                union(a, b);
            }
        }

        Set<Integer> set = new HashSet<>();

        for(int i=1; i<=N; i++){
            set.add(getParent(i));
        }

        System.out.println(cnt + set.size()-1);

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

        if(rank[aroot] == rank[broot]){
            parent[aroot] = broot;
            rank[broot]++;
        }else if(rank[aroot] < rank[broot]){
            parent[aroot] = broot;
        }else{
            parent[broot] = aroot;
        }
    }

    public static boolean isFamily(int a, int b){
        int aroot = getParent(a);
        int broot = getParent(b);
        if(aroot == broot){
            return true;
        }else{
            return false;
        }
    }
}