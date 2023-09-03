
import java.util.Scanner;

public class Main {

    static char[][][] arr;

    public static void init(){
        for(int i=0; i<6; i++){
            for(int r=0; r<3; r++){
                for(int c=0; c<3; c++){
                    if(i==0){
                        arr[i][r][c] = 'w';
                    }else if(i==1){
                        arr[i][r][c] = 'b';
                    }else if(i==2){
                        arr[i][r][c] = 'y';
                    }else if(i==3){
                        arr[i][r][c] = 'g';
                    }else if(i==4){
                        arr[i][r][c] = 'o';
                    }else if(i==5){
                        arr[i][r][c] = 'r';
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();

        for(int tc=0; tc<T; tc++){
            int N=sc.nextInt();
            arr = new char[6][3][3];
            init();

            for(int i=0; i<N; i++){
                char[] op = sc.next().toCharArray();

                if(op[0] == 'U'){
                    if(op[1]=='-'){
                        moveU();
                    }else{
                        moveU();
                        moveU();
                        moveU();
                    }
                }else if(op[0]=='D'){
                    if(op[1]=='-'){
                        moveD();
                    }else{
                        moveD();
                        moveD();
                        moveD();
                    }
                }else if(op[0]=='F'){
                    if(op[1]=='-'){
                        moveF();
                    }else{
                        moveF();
                        moveF();
                        moveF();
                    }
                }else if(op[0]=='B'){
                    if(op[1]=='-'){
                        moveB();
                    }else{
                        moveB();
                        moveB();
                        moveB();

                    }
                }else if(op[0]=='L'){
                    if(op[1]=='-'){
                        moveL();
                    }else{
                        moveL();
                        moveL();
                        moveL();
                    }
                }else if(op[0]=='R'){
                    if(op[1]=='-'){
                        moveR();
                    }else{
                        moveR();
                        moveR();
                        moveR();
                    }
                }

            }
            for(int r=0; r<3; r++){
                for(int c=0; c<3; c++){
                    System.out.print(arr[0][r][c]);
                }
                System.out.println();
            }
        }
    }


    public static void moveU(){
        char[] temp = new char[3];

        temp[0] = arr[1][0][0];
        temp[1] = arr[1][1][0];
        temp[2] = arr[1][2][0];

        arr[1][0][0] = arr[5][0][2];
        arr[1][1][0] = arr[5][0][1];
        arr[1][2][0] = arr[5][0][0];

        arr[5][0][2] = arr[3][2][2];
        arr[5][0][1] = arr[3][1][2];
        arr[5][0][0] = arr[3][0][2];

        arr[3][2][2] = arr[4][2][0];
        arr[3][1][2] = arr[4][2][1];
        arr[3][0][2] = arr[4][2][2];

        arr[4][2][0] = temp[0];
        arr[4][2][1] = temp[1];
        arr[4][2][2] = temp[2];


        // 면회전
        temp[0] = arr[0][0][0];
        temp[1] = arr[0][0][1];

        arr[0][0][0] = arr[0][0][2];
        arr[0][0][1] = arr[0][1][2];
        arr[0][0][2] = arr[0][2][2];

        arr[0][1][2] = arr[0][2][1];
        arr[0][2][2] = arr[0][2][0];

        arr[0][2][1] = arr[0][1][0];
        arr[0][2][0] = temp[0];
        arr[0][1][0] = temp[1];


    }
    public static void moveR(){
        char[] temp = new char[3];

        temp[0] = arr[2][0][0];
        temp[1] = arr[2][1][0];
        temp[2] = arr[2][2][0];

        arr[2][0][0] = arr[5][2][2];
        arr[2][1][0] = arr[5][1][2];
        arr[2][2][0] = arr[5][0][2];

        arr[5][2][2] = arr[0][2][2];
        arr[5][1][2] = arr[0][1][2];
        arr[5][0][2] = arr[0][0][2];

        arr[0][2][2] = arr[4][2][2];
        arr[0][1][2] = arr[4][1][2];
        arr[0][0][2] = arr[4][0][2];

        arr[4][2][2] = temp[0];
        arr[4][1][2] = temp[1];
        arr[4][0][2] = temp[2];

        // 면회전
        temp[0] = arr[1][0][0];
        temp[1] = arr[1][0][1];

        arr[1][0][0] = arr[1][0][2];
        arr[1][0][1] = arr[1][1][2];
        arr[1][0][2] = arr[1][2][2];

        arr[1][1][2] = arr[1][2][1];
        arr[1][2][2] = arr[1][2][0];

        arr[1][2][1] = arr[1][1][0];
        arr[1][2][0] = temp[0];
        arr[1][1][0] = temp[1];
    }
    public static void moveD(){
        char[] temp = new char[3];

        temp[0] = arr[3][0][0];
        temp[1] = arr[3][1][0];
        temp[2] = arr[3][2][0];

        arr[3][0][0] = arr[5][2][0];
        arr[3][1][0] = arr[5][2][1];
        arr[3][2][0] = arr[5][2][2];

        arr[5][2][0] = arr[1][2][2];
        arr[5][2][1] = arr[1][1][2];
        arr[5][2][2] = arr[1][0][2];

        arr[1][2][2] = arr[4][0][2];
        arr[1][1][2] = arr[4][0][1];
        arr[1][0][2] = arr[4][0][0];

        arr[4][0][2] = temp[0];
        arr[4][0][1] = temp[1];
        arr[4][0][0] = temp[2];

        // 면회전
        temp[0] = arr[2][0][0];
        temp[1] = arr[2][0][1];

        arr[2][0][0] = arr[2][0][2];
        arr[2][0][1] = arr[2][1][2];
        arr[2][0][2] = arr[2][2][2];

        arr[2][1][2] = arr[2][2][1];
        arr[2][2][2] = arr[2][2][0];

        arr[2][2][1] = arr[2][1][0];
        arr[2][2][0] = temp[0];
        arr[2][1][0] = temp[1];

    }
    public static void moveL(){
        char[] temp = new char[3];

        temp[0] = arr[0][0][0];
        temp[1] = arr[0][1][0];
        temp[2] = arr[0][2][0];

        arr[0][0][0] = arr[5][0][0];
        arr[0][1][0] = arr[5][1][0];
        arr[0][2][0] = arr[5][2][0];

        arr[5][0][0] = arr[2][2][2];
        arr[5][1][0] = arr[2][1][2];
        arr[5][2][0] = arr[2][0][2];

        arr[2][2][2] = arr[4][0][0];
        arr[2][1][2] = arr[4][1][0];
        arr[2][0][2] = arr[4][2][0];

        arr[4][0][0] = temp[0];
        arr[4][1][0] = temp[1];
        arr[4][2][0] = temp[2];

        // 면회전
        temp[0] = arr[3][0][0];
        temp[1] = arr[3][0][1];

        arr[3][0][0] = arr[3][0][2];
        arr[3][0][1] = arr[3][1][2];
        arr[3][0][2] = arr[3][2][2];

        arr[3][1][2] = arr[3][2][1];
        arr[3][2][2] = arr[3][2][0];

        arr[3][2][1] = arr[3][1][0];
        arr[3][2][0] = temp[0];
        arr[3][1][0] = temp[1];
    }
    public static void moveB(){
        char[] temp = new char[3];

        temp[0] = arr[1][0][0];
        temp[1] = arr[1][0][1];
        temp[2] = arr[1][0][2];

        arr[1][0][0] = arr[0][0][0];
        arr[1][0][1] = arr[0][0][1];
        arr[1][0][2] = arr[0][0][2];

        arr[0][0][0] = arr[3][0][0];
        arr[0][0][1] = arr[3][0][1];
        arr[0][0][2] = arr[3][0][2];

        arr[3][0][0] = arr[2][0][0];
        arr[3][0][1] = arr[2][0][1];
        arr[3][0][2] = arr[2][0][2];

        arr[2][0][0] = temp[0];
        arr[2][0][1] = temp[1];
        arr[2][0][2] = temp[2];

        // 면회전
        temp[0] = arr[4][0][0];
        temp[1] = arr[4][0][1];

        arr[4][0][0] = arr[4][0][2];
        arr[4][0][1] = arr[4][1][2];
        arr[4][0][2] = arr[4][2][2];

        arr[4][1][2] = arr[4][2][1];
        arr[4][2][2] = arr[4][2][0];

        arr[4][2][1] = arr[4][1][0];
        arr[4][2][0] = temp[0];
        arr[4][1][0] = temp[1];
    }
    public static void moveF(){
        char[] temp = new char[3];

        temp[0] = arr[1][2][0];
        temp[1] = arr[1][2][1];
        temp[2] = arr[1][2][2];

        arr[1][2][0] = arr[2][2][0];
        arr[1][2][1] = arr[2][2][1];
        arr[1][2][2] = arr[2][2][2];

        arr[2][2][0] = arr[3][2][0];
        arr[2][2][1] = arr[3][2][1];
        arr[2][2][2] = arr[3][2][2];

        arr[3][2][0] = arr[0][2][0];
        arr[3][2][1] = arr[0][2][1];
        arr[3][2][2] = arr[0][2][2];

        arr[0][2][0] = temp[0];
        arr[0][2][1] = temp[1];
        arr[0][2][2] = temp[2];


        // 면회전
        temp[0] = arr[5][0][0];
        temp[1] = arr[5][0][1];

        arr[5][0][0] = arr[5][0][2];
        arr[5][0][1] = arr[5][1][2];
        arr[5][0][2] = arr[5][2][2];

        arr[5][1][2] = arr[5][2][1];
        arr[5][2][2] = arr[5][2][0];

        arr[5][2][1] = arr[5][1][0];
        arr[5][2][0] = temp[0];
        arr[5][1][0] = temp[1];

    }




}
