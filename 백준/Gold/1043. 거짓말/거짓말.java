import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] truth;
    static List<Integer>[] list;
    static List<Integer> comb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        list = new ArrayList[N+1];

        for(int i=0; i<=N; i++){
            parent[i] = i;
            list[i] = new ArrayList();
        }

        st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        truth = new int[num];
        for(int i=0; i<num; i++){
            truth[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            comb = new ArrayList<>();

            for(int j=0; j<temp; j++){
                int a = Integer.parseInt(st.nextToken());
                list[a].add(i);
                comb.add(a);
            }
            if(temp >= 2){
                int root = comb.get(0);
                for(int j=1; j<comb.size(); j++){
                    union(root, comb.get(j));
                }
            }
        }

        for(int i=0; i<num; i++){
            parent[getParent(truth[i])] = 0;
        }

        Set<Integer> set = new HashSet<>();
        for(int i=1; i<=N; i++){
            int troot = getParent(i);

            if(troot == 0){
                set.addAll(list[i]);
            }
        }
        System.out.println(M - set.size());
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

        parent[aroot] = broot;
    }

}