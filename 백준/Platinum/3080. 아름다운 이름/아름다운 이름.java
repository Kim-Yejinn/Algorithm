import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node{
        Map<Character, Node> map;
        boolean isEnd;

        Node(){
            this.map = new HashMap<>();
            this.isEnd = false;
        }
    }
    public static class Trie{
        Node root;

        Trie(){
            this.root = new Node();
        }

        void insert(String str, int idx){
            Node cur = root;

            for(int i=0; i<idx; i++){
                char t = str.charAt(i);

                if(!cur.map.containsKey(t)){
                    cur.map.put(t, new Node());
                }
                cur = cur.map.get(t);
            }
            cur.isEnd = true;
        }

        long cnt(){
            long ans = 1;

            Queue<Node> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()){
                Node cur = q.poll();

                int curCnt = cur.map.size();
                if(cur.isEnd){
                    curCnt++;
                }
                ans =(ans * fac(curCnt)) % DIV;

                for(Character ch : cur.map.keySet()){
                    Node next = cur.map.get(ch);
                    q.offer(next);
                }
            }
            return ans;
        }
    }
    static long[] memo;
    public static long fac(int num){
        if(memo[num] != 0){
            return memo[num];
        }
        return memo[num] = (num * fac(num-1)) % DIV;
    }
    public static int common(String str1, String str2){
        int idx = 0;
        for(int i=0; i<Math.min(str1.length(), str2.length()); i++){
            char a = str1.charAt(i);
            char b = str2.charAt(i);
            if(a!=b){
                break;
            }
            idx++;
        }
        return idx;
    }
    static int DIV = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        memo = new long[3001];
        memo[0] = 1;
        memo[1] = 1;

        String[] str = new String[N];
        for(int i=0; i<N; i++){
            str[i] = br.readLine();
        }
        Arrays.sort(str);
        int idx1 = 0;
        int idx2 = 0;

        for(int i=0; i<N; i++){
            if(i==N-1){
                idx2 = str[i].length();
            }else{
                idx2 = common(str[i], str[i+1]);
            }
            int idx = Math.max(idx1, idx2)+1;
            idx = Math.min(idx, str[i].length());
            trie.insert(str[i], idx);
            idx1 = idx2;
        }
        System.out.println(trie.cnt());
    }
}