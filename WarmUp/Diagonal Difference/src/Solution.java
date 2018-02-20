import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 *  Given a square matrix of size N x N, calculate the absolute difference between the sums of its diagonals.
 */
public class Solution {

    static int diagonalDifference(int[][] a) {
        // Complete this function
        int diag1=0, diag2=0;
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                if(i==j)
                    diag1+=a[i][j];
                if(i+j==a.length-1)
                    diag2+=a[i][j];
            }
        }
        return Math.abs(diag1-diag2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for(int a_i = 0; a_i < n; a_i++){
            for(int a_j = 0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        int result = diagonalDifference(a);
        System.out.println(result);
        in.close();
    }
}
