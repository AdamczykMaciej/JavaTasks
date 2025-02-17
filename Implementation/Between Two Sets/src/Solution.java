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

    static int getTotalX(int[] a, int[] b) {
        // Complete this function
        int n=1, count_a=0, count_b=0, fincount=0;
        int min_b=b[0];
        for(int i=0; i<b.length; i++){
            if(b[i]<min_b)
                min_b=b[i];
        }
        while(n<=min_b){
        	count_a=0;
            for(int i=0; i<a.length; i++){
                if(n%a[i]==0)
                    count_a++;
            }
            if(count_a!=a.length) {
            	n++;
                continue;  
            }
            for(int i=0; i<b.length; i++){
                 if(b[i]%n==0)
                    count_b++;
            }
            if(count_b==b.length)
                fincount++;
            count_b=0;
            n++;
           
            
        }
        return fincount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}
