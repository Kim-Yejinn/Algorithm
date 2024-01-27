import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        Node[] num;

        Node(){
            num = new Node[2];
        }
    }

    public static class Trie{

        static Node root;

        Trie(){
            root = new Node();
        }

        void insert(int num){

            Node cur = root;

            for(int i=30; i>=0; i--){
                if((num &(1<<i)) >0){
                    // 1 넣기
                    if(cur.num[1] == null){
                        cur.num[1] = new Node();
                    }
                    cur = cur.num[1];
                }else{
                    // 0 넣기
                    if(cur.num[0] == null){
                        cur.num[0] = new Node();
                    }
                    cur = cur.num[0];
                }
            }

        }

        int search(int num){
            Node cur = root;

            int ans = 0;

            for(int i=30; i>=0; i--){
                if((num & (1<<i))>0){
                    // 1이 있을 경우
                    if(cur.num[0] != null){
                        cur = cur.num[0];
                    }else{
                        cur = cur.num[1];
                        ans = ans | (1<<i);
                    }
                }else{
                    if(cur.num[1] != null){
                        cur = cur.num[1];
                        ans = ans | (1<<i);
                    }else{
                        cur = cur.num[0];
                    }
                }
            }
            return ans;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            Trie trie = new Trie();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sum = 0;
            int ans = 0;

            trie.insert(0);

            for(int i=0; i<N; i++){
                int num = Integer.parseInt(st.nextToken());
                sum = sum^num;
                trie.insert(sum);
                ans = Math.max(ans, trie.search(sum)^sum);
            }

            System.out.println(ans);
        }

    }
}