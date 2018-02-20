import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and
 * maximum values as a single line of two space-separated long integers.
 */
public class Solution {

    static void miniMaxSum(int[] arr) {
        // Complete this function
        long mn=0, mx=0, sum;
        for(int i=0; i<arr.length; i++){
            sum=0;
            for(int j=0; j<arr.length; j++){
                if(j!=i)
                    sum+=arr[j];
            }
            if(i==0)
                mn=sum; //first minimal sum
            else if(sum<mn) mn=sum;
            if(sum>mx) mx=sum;
            
        }
        System.out.println(mn+" "+mx);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i = 0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        miniMaxSum(arr);
        in.close();
    }
}
