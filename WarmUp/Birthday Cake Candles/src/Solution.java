import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
 * Colleen is having a birthday! She will have a cake with one candle for each year of her age.
 * When she blows out the candles, she’ll only be able to blow out the tallest ones.
 * Find and print the number of candles she can successfully blow out.
 */
public class Solution {

    static int birthdayCakeCandles(int n, int[] ar) {
        // Complete this function
        int candles=0, tlst=0;
        //find the tallest
        for(int i=0; i<n; i++){
            if(ar[i]>tlst)
                tlst=ar[i];
        }
        //count them
        for(int i=0; i<n; i++){
            if(ar[i]==tlst)
                candles++;
        }
        return candles;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
