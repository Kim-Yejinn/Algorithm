
import java.util.Scanner;
import java.util.Stack;

public class Main {
    // 후위표기식
    // 1. 숫자는 스택에 추가
    // 2. 연산자가 나오면 2개를 pop해서 계산
    // 3. 먼저 pop이 두번째, 나중에 첫번째로 계산
    // 4. 계산한 값은 스택에 다시 넣는다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        String str = sc.next();

        for(int i = 0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        Stack<Double> st = new Stack<>();

        for(int j=0; j<str.length(); j++){
            char temp = str.charAt(j);

            if(temp >='A' && temp <= 'Z'){
                st.push(arr[temp-'A']*1.0);
            }else{
                Double b = st.pop();
                Double a = st.pop();

                Double ans = 0.0;
                if(temp == '*'){
                    ans = a*b;
                }else if(temp == '+'){
                    ans = a+b;
                }else if(temp == '/'){
                    ans = a/b;
                }else if(temp =='-'){
                    ans = a-b;
                }
                st.push(ans);
            }
        }
        System.out.println(String.format("%.2f", st.pop()));

    }

}
