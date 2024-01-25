import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        TreeMap<String, Node> child;
        boolean isLast;

        public Node(){
            this.child = new TreeMap<>();
            this.isLast = false;
        }
    }

    static class Trie{
        // 0. root node
        static Node root;

        // 1. 생성자
        public Trie(){
            root = new Node();
        }

        // 2. insert

        void insert(List<String> list){
            // 입력을 받아와서 넣자

            // 0) 시작점
            Node cur = root;

            // 1) 돌면서 가자
            for(int i=0; i<list.size(); i++){
                String str = list.get(i);

                // 1-1) 현재에 존재하는 가?
                if(!cur.child.containsKey(str)){
                    // 존재 하지 않을 경우 넣어 주어야 한다.
                    cur.child.put(str, new Node());
                }
                // 2) 다음으로 이동한다
                cur = cur.child.get(str);
            }
        }

        // 3. print
        void print(){
            printAll(root, 0);
        }

        void printAll(Node cur, int num){
            // 해당 것 추가
            Iterator<String> it = cur.child.keySet().iterator();

            while (it.hasNext()){
                for(int i=0; i<num; i++){
                    sb.append("--");
                }
                String str = it.next();
                sb.append(str);
                sb.append("\n");
                printAll(cur.child.get(str), num+1);
            }
        }

    }

    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Trie trie = new Trie();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            List<String> list = new ArrayList<>();
            int K = Integer.parseInt(st.nextToken());

            for(int j=0; j<K; j++){
                list.add(st.nextToken());
            }
            trie.insert(list);
        }
        sb = new StringBuilder();
        trie.print();

        System.out.println(sb);
    }

}