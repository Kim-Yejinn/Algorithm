import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] rank;
    static int[] degree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        rank = new int[V+1];
        degree = new int[V+1];

        for(int i=1; i<=V; i++){
            parent[i]=i;
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            degree[a]++;
            degree[b]++;
            union(a, b);
        }
        Set<Integer> set = new HashSet<>();

        for(int i=1; i<=V; i++){
            int temp = getParent(i);

            set.add(temp);
        }

        if(set.size() != 1){
            System.out.println("NO");
        }else{
            int cnt = 0;

            for(int i=1; i<=V; i++){
                if(degree[i]%2 ==1){
                    cnt++;
                }
            }

            if(cnt == 2 || cnt == 0){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

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
        }else if(rank[aroot] < rank[broot]){
            parent[aroot] = broot;
        }else{
            parent[broot] = aroot;
        }
    }
}