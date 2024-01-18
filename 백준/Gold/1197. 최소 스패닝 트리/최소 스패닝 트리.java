import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node{
        int st;
        int ed;
        int weight;

        Node(int st, int ed, int weight){
            this.st = st;
            this.ed = ed;
            this.weight = weight;
        }
    }

    static int V;
    static int E;
    static PriorityQueue<Node> q;
    static int sum;

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        q = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        sum = 0;

        parent = new int[V+1];
        rank = new int[V+1];

        for(int i=0; i<=V; i++){
            parent[i] = i;
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            q.offer(new Node(s, f, w));
        }

        kruskalMST();
        System.out.println(sum);

    }

    public static int getParent(int x){
        if(x==parent[x]){
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
    public static void kruskalMST(){
        while(!q.isEmpty()){

            // 가중치가 가장 작은 간선
            Node temp = q.poll();

            if(getParent(temp.st) != getParent(temp.ed)){
                // 부모가 다른 간선일 경우 - 사이클이 아닐때
                // 연결 해주고
                union(temp.st, temp.ed);
                // 추가해준다
                sum += temp.weight;
            }

        }

    }

}