import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            String s =sc.next();
            String t =sc.next();

            int idx = 0;

            for(int i=0; i<t.length(); i++){
                char temp = t.charAt(i);

                if(s.charAt(idx) ==  temp){
                    idx++;
                    if(idx == s.length()){
                        break;
                    }
                }
            }

            if(idx == s.length()){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }

        }
    }
}