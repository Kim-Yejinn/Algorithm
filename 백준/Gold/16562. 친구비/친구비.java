import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static int[] price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        price = new int[N+1];

        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        Set<Integer> set = new HashSet<>();

        for(int i=1; i<=N; i++){
            set.add(getParent(i));
        }

        Iterator<Integer> it = set.iterator();

        int sum = 0;
        while (it.hasNext()){
            int idx = it.next();
            sum += price[idx];
        }

        if(sum>K){
            System.out.println("Oh no");
        }else{
            System.out.println(sum);
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

        if(price[aroot] == price[broot]){
            // 아무거
            parent[aroot] = broot;
        }else if(price[aroot] < price[broot]){
            // 싼곳에 붙자
            parent[broot] = aroot;
        }else{
            parent[aroot] = broot;
        }

    }
}