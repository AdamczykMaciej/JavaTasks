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

    static int[] breakingRecords(int[] score) {
        // Complete this function
        int mx=score[0], mn=score[0];
        int[] count=new int[2];
        for(int i=1; i<score.length; i++){
            if(mx<score[i]){
                mx=score[i];
                count[0]++;
            }
            if(mn>score[i]){
                mn=score[i];
                count[1]++;
            }
        }
        return count;
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for(int score_i = 0; score_i < n; score_i++){
            score[score_i] = in.nextInt();
        }
        int[] result = breakingRecords(score);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
