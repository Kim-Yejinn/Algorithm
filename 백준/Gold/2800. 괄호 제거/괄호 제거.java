
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static class Node{
        int st;
        int ed;

        Node(int st, int ed){
            this.st = st;
            this.ed = ed;
        }
    }

    static ArrayList<Node> list;
    static ArrayList<String> ans;
    static boolean[] select;
    static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        Stack<Integer> st = new Stack<>();
        list = new ArrayList<>();
        ans = new ArrayList<>();
        select = new boolean[10];



        for(int i=0; i<str.length(); i++){
            char temp = str.charAt(i);

            if(temp == '('){
                st.push(i);
            }else if(temp == ')'){
                int num = st.pop();
                list.add(new Node(num, i));
            }
        }
        rec(0);

        Collections.sort(ans);
        String last = "";
        for(int i=1; i<ans.size(); i++){
            if(last.equals(ans.get(i))){
                continue;
            }else{
                System.out.println(ans.get(i));
                last = ans.get(i);
            }
        }
    }
    public static void rec(int num){
        if(list.size() == num){
            print();
            return;
        }

        // 지웠을 때
        select[num] = true;
        rec(num+1);
        // 안지웠을 때
        select[num] = false;
        rec(num+1);
    }
    public static boolean[] check;
    public static void print(){
        printCheck();
        String temp = "";
        for(int i=0; i<str.length(); i++){
            if(!check[i]){
                temp+=str.charAt(i);
            }
        }
        ans.add(temp);
    }

    public static void printCheck(){
        check = new boolean[201];

        for(int i=0; i<list.size(); i++){
            if(select[i]){
                check[list.get(i).st] = true;
                check[list.get(i).ed] = true;
            }
        }
    }
}
