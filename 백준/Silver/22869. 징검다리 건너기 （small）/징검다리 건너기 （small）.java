import java.io.*;
import java.util.*;
 
public class Main {
    static int n,k;
    static int []arr;
    static boolean[]dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
 
        String[] s1 = br.readLine().split(" ");
 
        n = Integer.parseInt(s1[0]);
        k = Integer.parseInt(s1[1]);
 
        arr = new int[n];
 
        String[] s = br.readLine().split(" ");
 
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
 
        dp = new boolean[n+1];
 
 
        dfs(1);
 
        System.out.println(dp[n]?"YES":"NO");
    }
 
    private static void dfs(int index){
        if(index==n){
            dp[index]=true;
            return;
        }
        if(dp[index]){
            return;
        }
 
        dp[index]=true;
        for(int i=index+1; i<=n; i++){
            if((i-index)*(1+Math.abs(arr[index-1]-arr[i-1]))<=k){
                dfs(i);
            }
        }
    }
}