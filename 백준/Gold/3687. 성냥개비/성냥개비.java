import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static boolean isBig(String a, String b){
        if(a.length() > b.length()){
            return true;
        }else if(a.length() < b.length()){
            return false;
        }else{
            for(int i=0; i<a.length(); i++){
                char at = a.charAt(i);
                char bt = b.charAt(i);

                if(at>bt){
                    return true;
                }else if(at<bt){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isSmall(String a, String b){
        if(a.length()<b.length()){
            return true;
        }else if(a.length() > b.length()){
            return false;
        }else{
            for(int i=0; i<a.length(); i++){
                char at = a.charAt(i);
                char bt = b.charAt(i);

                if(at < bt){
                    return true;
                }else if(at > bt){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        String[] max = new String[101];
        String[] min = new String[101];

        char[] maxArr = {'0','0','1','7','4','5','9','8'};
        char[] minArr = {'0','0','1','7','4','2','0','8'};

        for(int i=2; i<8; i++){
            max[i] = maxArr[i]+"";
            min[i] = minArr[i]+"";
        }
        min[6] = "6";

        for(int i=1; i<101; i++){
            for(int j=2; j<8; j++){
                if(i-j < 2){
                    break;
                }
                String maxt = max[i-j]+maxArr[j];
                String mint = min[i-j]+minArr[j];

                if(max[i] == null || isBig(maxt, max[i]) ){
                    max[i] = maxt;
                }

                if(min[i] == null || isSmall(mint, min[i])){
                    min[i] = mint;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc=0; tc<T; tc++){
            int N = Integer.parseInt(br.readLine());
            sb.append(min[N]).append(" ").append(max[N]).append("\n");
        }
        System.out.println(sb);
    }
}