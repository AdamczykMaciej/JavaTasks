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

    static String solve(int[] a){
        // Complete this function
        int l=0, r=0;
        if(a.length==1)
                return "YES";
        //Algorithm Complexity O(n^2)
        
        // for(int i=1; i<a.length; i++){
        //     else if(a.length==2)
        //         return "NO";
        //     for(int j=0; j<a.length; j++){
        //         if(j<i){
        //             l+=a[j];
        //         }
        //         else if(j>i){
        //             r+=a[j];
        //         }
        //     }
        //     if(l==r)
        //         return "YES";
        // }
        // return "NO";
        
        //Algorithm Complexity O(n)
        //Space Complexity O(2n)
        
        int[][] count=new int[a.length][2];
        int sum=0;
        for(int i=0; i<a.length; i++){
            sum+=a[i];
            count[i][0]+=sum;
        }
        sum=0;
        for(int i=a.length-1; i>=0; i--){
            sum+=a[i];
            count[i][1]+=sum;
        }
        for(int i=1; i<a.length-1; i++){
            if(a.length==2)
                return "NO";
            if(count[i-1][0]==count[i+1][1])
                return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
    }
}
