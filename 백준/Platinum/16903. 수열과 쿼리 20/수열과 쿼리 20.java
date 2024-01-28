import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        Node[] child;
        int cnt;
        Node(){
            // 0과 1만 저장할 것이니까
            child = new Node[2];
            cnt = 0;
        }
    }

    public static class Trie{

        // 루트
        Node root;

        Trie(){
            root = new Node();
        }

        // insert
        void insert(int num){
            Node cur = root;

            for(int i=30; i>=0; i--){
                if((num & (1<<i))>0){
                    // 1
                    if(cur.child[1] == null){
                        cur.child[1] = new Node();
                    }
                    cur = cur.child[1];
                    cur.cnt++;
                }else{
                    // 0
                    if(cur.child[0] == null){
                        cur.child[0] = new Node();
                    }
                    cur = cur.child[0];
                    cur.cnt++;
                }
            }
        }

        // remove
        void remove(int num){
            Node cur = root;

            for(int i=30; i>=0; i--){
                if((num & (1<<i))>0){
                    // 1
                    Node next = cur.child[1];
                    next.cnt--;
                    if(next.cnt == 0){
                        cur.child[1] = null;
                        break;
                    }else{
                        cur = next;
                    }
                }else{
                    // 0
                    Node next = cur.child[0];
                    next.cnt--;
                    if(next.cnt == 0){
                        cur.child[0] = null;
                        break;
                    }else{
                        cur = next;
                    }
                }
            }
        }

        // xor
        int xor(int num){
            int ans = 0;
            Node cur = root;

            for(int i=30; i>=0; i--){
                if((num & (1<<i))>0){
                    // 1
                    if(cur.child[0]!=null){
                        cur = cur.child[0];
                    }else{
                        cur = cur.child[1];
                        ans = ans | (1<<i);
                    }
                }else{
                    // 0
                    if(cur.child[1]!=null){
                        cur = cur.child[1];
                        ans = ans| (1<<i);
                    }else{
                        cur = cur.child[0];
                    }
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        Trie trie = new Trie();
        StringBuilder sb = new StringBuilder();
        trie.insert(0);

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());

            if(op==1){
                int num = Integer.parseInt(st.nextToken());
                trie.insert(num);
            } else if(op == 2){
                int num = Integer.parseInt(st.nextToken());
                trie.remove(num);
            }else{
                int num = Integer.parseInt(st.nextToken());
                sb.append(trie.xor(num)^num).append("\n");
            }
        }
        System.out.println(sb);
    }
}