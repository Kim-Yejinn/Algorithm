
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0; i<N; i++) {
            String str = sc.next();

            Stack<Character> front = new Stack<>();
            Stack<Character> back = new Stack<>();

            for (int j = 0; j < str.length(); j++) {
                char temp = str.charAt(j);

                if (temp == '<') {
                    if (!front.isEmpty()) {
                        back.push(front.pop());
                    }
                } else if (temp == '>') {
                    if (!back.isEmpty()) {
                        front.push(back.pop());
                    }
                } else if (temp == '-') {
                    if (!front.isEmpty()) {
                        front.pop();
                    }
                } else {
                    front.push(temp);
                }
            }
            StringBuilder sb = new StringBuilder();

            while(!back.isEmpty()){
                front.push(back.pop());
            }
            while (!front.isEmpty()) {
                sb.append(front.pop());
            }
            System.out.println(sb.reverse());
        }
    }
}
