
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] cnt = new int[N+1];
        int[] num = new int[N+1];
        int[] input = new int[N+1];

        Stack<Integer> st = new Stack<>();

        // 입력
        for(int i=1; i<=N; i++){
            input[i] = sc.nextInt();
        }

        for(int i=1; i<=N; i++){
            while (!st.isEmpty()){
                int last = st.peek();
                if(input[last] > input[i]){
                    cnt[i] += st.size();
                    num[i] = last;
                    st.push(i);
                    break;
                }else{
                    st.pop();
                }
            }
            if(st.isEmpty()) {
                st.push(i);
            }
        }

        st = new Stack<>();
        for(int i=N; i>=1; i--){
            while (!st.isEmpty()){
                int last = st.peek();
                if(input[last] > input[i]){
                    cnt[i] += st.size();
                    int dis1 = Math.abs(i-last);
                    int dis2 = Math.abs(num[i]-i);
                    if(dis1<dis2|| num[i]==0){
                        num[i] = last;
                    }
                    st.push(i);
                    break;
                }else{
                    st.pop();
                }
            }
            if(st.isEmpty()) {
                st.push(i);
            }
        }

        // 출력
        for(int i=1; i<=N; i++){
            if(cnt[i]==0){
                System.out.println(0);
            }else{
                System.out.println(cnt[i]+" "+num[i]);
            }
        }
    }
}
