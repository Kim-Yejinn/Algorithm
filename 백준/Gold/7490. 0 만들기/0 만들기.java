import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static char[] sel;
    static List<String> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            N = Integer.parseInt(br.readLine());
            sel = new char[2*N];
            sel[2*N-1] = 'E';
            ans = new ArrayList<>();
            for(int i=1, idx = 0; i<=N; i++, idx+=2){
                sel[idx] = (char) ('0'+i);
            }
            rec(1);
            for(int j=0; j<ans.size(); j++){
                System.out.println(ans.get(j));
            }
            System.out.println();
        }

    }
    public static void rec(int num){
        if(num == 2*N-1){
            cal();

            return;
        }
        sel[num] = ' ';
        rec(num+2);
        sel[num] = '+';
        rec(num+2);
        sel[num] = '-';
        rec(num+2);
    }
    public static void cal(){
        int ret = 0;
        StringBuilder temp = new StringBuilder();
        StringBuilder str = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<2*N; i++){
            char t = sel[i];
            if(t !='E'){
                str.append(t);
            }
            if(t == '+' || t == '-' || t == 'E') {
                int num = Integer.parseInt(temp.toString());
                if(st.isEmpty()){
                    ret += num;
                    st.push(t);
                }else {
                    char op = st.pop();
                    if(op == '+'){
                        ret += num;
                    }else{
                        ret -= num;
                    }
                    st.push(t);
                }
                temp.setLength(0);
            }else if(t == ' '){
            }else{
                temp.append(t);
            }
        }
        if(ret == 0){
            ans.add(str.toString());
        }
    }
}