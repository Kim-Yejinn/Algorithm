import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int g;
        int s;
        int b;
        int num;
        Node(int g, int s, int b, int num){
            this.g = g;
            this.s = s;
            this.b = b;
            this.num = num;
        }

        @Override
        public int compareTo( Node o) {
            if(this.g == o.g){
                if(this.s == o.s){
                    return o.b - this.b;
                }else{
                    return o.s - this.s;
                }
            }else{
                return o.g - this.g;
            }
        }

    }
    public static boolean isSame(int a, int b){
        Node aNode = list.get(a);
        Node bNode = list.get(b);

        if(aNode.g != bNode.g){
            return false;
        }
        if(aNode.s != bNode.s){
            return false;
        }
        if(aNode.b != bNode.b){
            return false;
        }
        return true;
    }

    static ArrayList<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new Node(b,c, d, a));
        }
        Collections.sort(list);
        int[] rank = new int[N+1];

        int idx = 1;
        for(int i=0; i<list.size(); i++){
            Node temp = list.get(i);

            rank[temp.num] = idx;

            int j = i-1;
            int last = i;
            while (j > 0){
                if(isSame(i, j)){
                    last = j;
                }
                j--;
            }

            for(int k = last+1; k<=i; k++){
                Node t = list.get(k);
                rank[t.num] = rank[list.get(last).num];
            }
            idx++;
        }
        System.out.println(rank[K]);
    }
}