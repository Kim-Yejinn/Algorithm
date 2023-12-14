
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = 0;

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int t = 0; t<N; t++){
            int x = sc.nextInt();
            int y = sc.nextInt();


            while (!st.isEmpty()){
                int last = st.peek();

                if(last < y){
                    st.push(y);
                    break;
                }else if(last == y){
                    break;
                } else {
                    // last > y
                    st.pop();
                    cnt++;
                }
            }
        }

        while(!st.isEmpty()){
            if(st.peek() == 0){
                break;
            }
            st.pop();
            cnt++;
        }

        System.out.println(cnt);
    }
}
