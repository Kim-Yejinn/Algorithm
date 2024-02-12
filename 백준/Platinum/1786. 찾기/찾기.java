import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] pi;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String text = br.readLine();

        pi = new int[text.length()];
        list = new ArrayList<>();

        kmp(str, text);
        System.out.println(list.size());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    public static void prefix(String text){
        int j = 0;

        for(int i=1; i<text.length(); i++){
            while (j>0 && (text.charAt(i) != text.charAt(j))){
                j = pi[j-1];
            }

            if(text.charAt(i) == text.charAt(j)){
                j++;
            }
            pi[i] = j;
        }
    }

    public static void kmp(String str, String text){
        prefix(text);
        int j =0;

        for(int i = 0; i<str.length(); i++){
            while(j>0 && text.charAt(j) != str.charAt(i)){
                j = pi[j-1];
            }

            if(str.charAt(i) == text.charAt(j)){
                if(j == text.length()-1){
                    // 같으면
                    list.add(i - text.length() + 2);
                    j = pi[j];
                }else{
                    j++;
                }
            }
        }
    }
}