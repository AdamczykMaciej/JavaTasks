import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Write a program that prints a staircase of size n.
 */
public class Solution {

    static void staircase(int n) {
        // Complete this function
    	int j;
    	 for(int i=1; i<=n; i++){
             for(j=0; j<n-i; j++){
                 System.out.print(" ");
             }
             for(int k=j; k<n; k++){
                 System.out.print("#");
             }
             System.out.println("");
         }
    	
    	
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        staircase(n);
        in.close();
    }
}
