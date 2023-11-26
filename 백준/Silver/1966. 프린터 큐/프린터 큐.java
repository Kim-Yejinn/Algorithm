
import java.util.*;

public class Main {
    public static class Node{
        int num;
        int prior;

        Node(int num, int prior){
            this.num = num;
            this.prior = prior;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();


        for(int tc = 0; tc<T; tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            // 답 순서
            int ans = 0;

            // 순서를 넣자
            ArrayList<Integer> list = new ArrayList<>();

            // 인덱스
            int idx = 0;

            // 문서들 번호
            Queue<Node> q = new LinkedList<>();

            for(int i =0; i<N; i++){
                int pri = sc.nextInt();
                q.add(new Node(i, pri));
                list.add(pri);
            }
            Collections.sort(list,Collections.reverseOrder());

            while(!q.isEmpty()){
                Node temp = q.poll();

                if(list.get(idx) == temp.prior){
                    ans++;
                    idx++;
                    if(temp.num == M){
                        System.out.println(ans);
                        break;
                    }
                }else{
                    q.add(temp);
                }
            }
        }

    }
}
