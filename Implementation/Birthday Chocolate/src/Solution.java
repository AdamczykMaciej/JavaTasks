import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * 
 * @author Maciej Adamczyk
 *
 */
public class Solution {

    static int solve(int n, int[] s, int d, int m){
        // Complete this function
        int solcount=0, pieces_sum=0;
        for(int i=0; i<n; i++){
            pieces_sum=0;
            for(int j=i; j<i+m; j++){
                if(i+m>n)
                    break;
                pieces_sum+=s[j];
            }
            if(pieces_sum==d) solcount++;
        }
        return solcount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}
