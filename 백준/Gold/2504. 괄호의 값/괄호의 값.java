
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        Stack<String> st = new Stack<>();
        boolean flag = true;

        for(int i=0; i<str.length(); i++){
            char temp = str.charAt(i);

            if(temp == '(' || temp == '['){
                st.push(temp+"");
            }else if(temp == ')'){
                int sum = 0;

                while(flag){
                    if(st.isEmpty()){
                        flag = false;
                        break;
                    }
                    String t = st.pop();
                    if(t.equals("(")){
                        if(sum == 0){
                            st.push("2");
                        }else{
                            st.push(sum*2+"");
                        }
                        break;
                    }else if(t.equals("[")){
                        flag = false;
                    }else{
                        sum += Integer.parseInt(t);
                    }
                }
            }else if(temp == ']'){
                int sum = 0;
                while(flag){
                    if(st.isEmpty()){
                        flag = false;
                        break;
                    }
                    String t = st.pop();
                    if(t.equals("[")){
                        if(sum == 0){
                            st.push("3");
                        }else{
                            st.push(sum*3+"");
                        }
                        break;
                    }else if(t.equals("(")){
                        flag = false;
                    }else{
                        sum += Integer.parseInt(t);
                    }
                }
            }
            if(!flag){
                break;
            }
        }

        int ans = 0;

        if(flag){
            while(!st.isEmpty()){
                String temp = st.pop();
                if(temp.equals("(")||temp.equals(")")||temp.equals("[")||temp.equals("]")){
                    System.out.println("0");
                    return;
                }

                ans += Integer.parseInt(temp);
            }
            System.out.println(ans);
        }else{
            System.out.println("0");
        }
    }
}
