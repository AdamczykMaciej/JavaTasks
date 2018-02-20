import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Given an array of integers, calculate which fraction of its elements are positive,
 * which fraction of its elements are negative, and which fraction of its elements are zeroes, respectively.
 * Print the decimal value of each fraction on a new line.
 */
public class Solution {

    static void plusMinus(int[] arr) {
        // Complete this function
         double pos=0, neg=0, zer=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>0) pos++;
            else if(arr[i]<0) neg++;
            else zer++;
        }
        System.out.println(Math.round(pos/arr.length *1000000)/1000000d);
        System.out.println(Math.round(neg/arr.length *1000000d)/1000000d);
        System.out.println(Math.round(zer/arr.length *1000000d)/1000000d);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();
    }
}
