import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static int[] parent;
    static int[] rank;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            rank = new int[N+1];
            parent = new int[N+1];

            // 자기 자신을 가리키도록
            for(int i=0; i<N+1; i++){
                parent[i] = i;
            }

            // 입력
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            Set<Integer> set = new HashSet<>();

            for(int i=1; i<N+1; i++){
                set.add(getParent(i));
            }

            System.out.println("#"+tc+" "+set.size());
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
            // 아무데나 붙이자
            parent[aroot] = broot;
            rank[broot] ++;
        }else if(rank[aroot] < rank[broot]){
            // 큰곳에 붙이자
            parent[aroot] = broot;
        }else{
            parent[broot] = aroot;
        }
    }
}