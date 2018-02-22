import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * There are two kangaroos on a number line ready to jump in the positive direction (i.e, toward +infinity ). Each kangaroo takes the same amount of time to make a jump, regardless of distance. That is, if kangaroo one jumps 3 meters and kangaroo two jumps 5 meters, they each do it in one second, for example.

Given the starting locations and jump distances for each kangaroo, determine if and when they will land at the same location at the same time.

Input Format

A single line of four space-separated integers denoting the respective values of x1, v1, x2, and v2.
Constraints:
0<=x1<x2<10000
 */

/**
 * 
 * @author Maciej Adamczyk
 *
 */
public class Solution {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        // Complete this function
        while(true){
            x1+=v1;
            x2+=v2;
            if(x1>x2)
                return "NO";
            if(x1==x2)
                return "YES";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
