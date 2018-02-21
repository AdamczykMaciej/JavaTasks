import java.io.*;
import java.util.*;

/*
 * Given a list of N fractions, output the fraction that appears the most often, in its most reduced form

It is guaranteed that there is a fraction that appears more than any other

Input Format

First line contains an integer N

The next N lines contain a fraction each of the form ai/bi eg. 2/3, 4/5
 */
public class Solution {
    public static int egcd(int a, int b) {
    if (a == 0)
        return b;

    while (b != 0) {
        if (a > b)
            a = a - b;
        else
            b = b - a;
    }

    return a;
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int numOfVariables = Integer.parseInt(scan.next());
        String mxNum="";
        int mxcounter=0;
        int counter=0;
        String[] arr2 = new String[numOfVariables];
        int a=0;
        while(scan.hasNext()){
            String[] arr = scan.next().split("/");
            int biggestDiv=2;
            int first=Integer.parseInt(arr[0]), second= Integer.parseInt(arr[1]);
            while(biggestDiv!=1){
            biggestDiv=egcd(first, second);
            first=first/biggestDiv;
            second=second/biggestDiv;
            }
            String frac=first+"/"+second;
            arr2[a]=frac;
            a++;
        }
        for(int i=0;i<arr2.length;i++){
            counter=0;
                for(int j=0;j<arr2.length;j++){
                    if(arr2[i].equals(arr2[j])) counter++;
                }
            if(counter>mxcounter){
                mxcounter=counter;
                mxNum=arr2[i];
            }
        }
        System.out.println(mxNum);
    }
}