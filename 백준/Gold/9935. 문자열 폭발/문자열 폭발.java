import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String bomb = sc.next();

        Stack<Character> st = new Stack<>();
        Stack<Character> temp = new Stack<>();

        for(int i=0; i<str.length();i++){
            st.push(str.charAt(i));

            temp.clear();
            for(int j=bomb.length()-1; j>=0; j--){
                if(st.isEmpty()){
                    while(!temp.isEmpty()){
                        // 안 겹치면 다시 넣어두기
                        st.push(temp.pop());
                    }
                    break;
                }else{
                    if(st.peek() == bomb.charAt(j)){
                        // 폭탄이랑 겹치는것이 있으면
                        temp.push(st.pop());
                    }else{
                        while(!temp.isEmpty()){
                            // 안 겹치면 다시 넣어두기
                            st.push(temp.pop());
                        }
                        break;
                    }
                }
            }

        }

        if(st.isEmpty()){
            System.out.println("FRULA");
        }else{
            StringBuilder sb = new StringBuilder();
            while (!st.isEmpty()){
                sb.append(st.pop());
            }
            System.out.println(sb.reverse());
        }
    }
}