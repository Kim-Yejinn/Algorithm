import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] left;
    static int[] right;

    static String ans1;
    static String ans2;
    static String ans3;
    static char[] conv = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int N = sc.nextInt();
        left = new int[27];
        right = new int[27];

        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        ans1 ="";
        ans2 ="";
        ans3 ="";

        for(int i=0; i<N; i++){
            int idx= sc.next().charAt(0)-'A';
            char l = sc.next().charAt(0);
            if(l != '.'){
                left[idx] = l-'A';
            }
            char r = sc.next().charAt(0);
            if(r != '.'){
                right[idx] = r-'A';
            }
        }

        first(0);
        mid(0);
        last(0);

        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);

    }
    public static void first(int num){
        // root
        ans1+=conv[num];
        // left
        if(left[num]!=-1){
            first(left[num]);
        }
        // right
        if(right[num]!=-1){
            first(right[num]);
        }
    }
    public static void mid(int num){
        // left
        if(left[num]!=-1){
            mid(left[num]);
        }
        // root
        ans2+=conv[num];
        // right
        if(right[num]!=-1){
            mid(right[num]);
        }
    }
    public static void last(int num){
        // left
        if(left[num]!=-1){
            last(left[num]);
        }
        // right
        if(right[num]!=-1){
            last(right[num]);
        }
        // root
        ans3+= conv[num];
    }
}