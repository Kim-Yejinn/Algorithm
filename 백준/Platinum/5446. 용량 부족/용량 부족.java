import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node{
        Map<Character, Node> map;
        char temp;
        boolean isEnd;
        boolean canRemove;

        Node(){
            map = new HashMap<>();
            isEnd = false;
            canRemove = true;
        }
    }

    public static class Trie{

        Node root;

        Trie(){
            root = new Node();
        }

        void insert(String str){
            Node cur = root;

            for(int i=0; i<str.length(); i++){
                char t = str.charAt(i);

                if(!cur.map.containsKey(t)){
                    cur.map.put(t, new Node());
                    cur.map.get(t).temp = t;
                }
                cur = cur.map.get(t);
            }
            cur.isEnd = true;
        }

        void notRemove(String str){
            Node cur = root;

            for(int i=0; i<str.length(); i++){
                char t = str.charAt(i);
                // canRemove를 모두 불가능으로..
                cur.canRemove = false;
                if(cur.map.containsKey(t)){
                    cur = cur.map.get(t);
                }else{
                    // 없으면 굳이 더 안해도 될듯
                    break;
                }
            }
            cur.canRemove = false;
        }

        int count(){
            int ans = 0;
            // 모든 곳을 찾아 갈 거임.
            // 다 지울 수 있으면 그냥 지워 버린다
            // 다 지울 수는 없는데 끝이면 카운트
            Queue<Node> q = new LinkedList<>();
            q.offer(root);

            while(!q.isEmpty()){
                Node temp = q.poll();

                if(temp.canRemove){
                    ans++;
                    continue;
                }
                if(temp.isEnd){
                    ans++;
                }
                // 돌면서 다 추가해주자
                for (Character ch : temp.map.keySet()) {
                    q.offer(temp.map.get(ch));
                }
            }
            return ans;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());

            Trie trie = new Trie();

            for(int i=0; i<N; i++){
                trie.insert(br.readLine());
            }

            int M = Integer.parseInt(br.readLine());

            for(int i=0; i<M; i++){
                trie.notRemove(br.readLine());
            }

            System.out.println(trie.count());
        }
    }
}