import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            String input = br.readLine();
            if(input.equals("end")){
                break;
            }

            int ocnt = 0;
            int xcnt = 0;
            int row = 0;
            int col = 0;
            int cross = 0;
            boolean oend = false;
            boolean xend = false;
            char[] arr = new char[9];

            for(int r=0; r<3; r++){
                int o = 0;
                int x = 0;
                for(int c=0; c<3; c++){
                    char temp = input.charAt(r*3 + c);
                    arr[r*3+c] = temp;

                    if(temp == 'X'){
                        xcnt++;
                        x++;
                    }else if(temp == 'O'){
                        ocnt++;
                        o++;
                    }
                }

                if(o==3){
                    row++;
                    oend = true;
                }
                if(x == 3){
                    row++;
                    xend = true;
                }
            }
            for(int c=0; c<3; c++){
                int o = 0;
                int x = 0;
                for(int r=0; r<3; r++){
                    char temp = input.charAt(r*3+c);
                    if(temp == 'X'){
                        x++;
                    }else if(temp == 'O'){
                        o++;
                    }
                }
                if(o==3){
                    col++;
                    oend = true;
                }
                if(x==3){
                    col++;
                    xend = true;
                }
            }

            if(arr[0] == arr[4] && arr[4]== arr[8] || arr[2] == arr[4] && arr[4] == arr[6]){
                if(arr[4]=='O'){
                    cross++;
                    oend = true;
                }else if(arr[4] == 'X'){
                    cross++;
                    xend = true;
                }
            }

            if(row >=2 || col >=2){
                sb.append("invalid").append("\n");
                continue;
            }

            if(ocnt > xcnt){
                sb.append("invalid").append("\n");
                continue;
            }

            if(oend && xend){
                sb.append("invalid").append("\n");
                continue;
            }
            if(oend){
                if(ocnt != xcnt){
                    sb.append("invalid").append("\n");
                }else{
                    sb.append("valid").append("\n");
                }
                continue;
            }
            if(xend){
                if(ocnt+1 != xcnt){
                    sb.append("invalid").append("\n");
                }else{
                    sb.append("valid").append("\n");
                }
                continue;
            }

            if (ocnt+xcnt == 9){
                sb.append("valid").append("\n");
            }else{
                sb.append("invalid").append("\n");
            }
        }
        System.out.println(sb);
    }
}