import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Lisa just got a new math workbook. A workbook contains exercise problems, grouped into chapters.
There are n chapters in Lisa's workbook, numbered from 1 to n.
The i-th chapter has ti problems, numbered from 1 to ti .
Each page can hold up to k problems. There are no empty pages or unnecessary spaces, so only the last page of a chapter may contain fewer than k problems.
Each new chapter starts on a new page, so a page will never contain problems from more than one chapter.
The page number indexing starts at 1.
Lisa believes a problem to be special if its index (within a chapter) is the same as the page number where it's located. Given the details for Lisa's workbook, can you count its number of special problems?
 */

/**
 * 
 * @author Maciej Adamczyk
 *
 */
public class Solution {

    static int workbook(int n, int k, int[] arr) {
        // Complete this function
        int page=1, count=0, boundary=k; // we need this boundary, cause our k will be changing proportionally to our multiplier. We will multiply the boundary and multiplier.
        int multiplier=2;
        for(int i=0; i<arr.length; i++){
            k=boundary;
            multiplier=2;
            for(int j=1; j<=arr[i]; j++){
                if(j>k){
                    page++;
                    k=boundary*multiplier;
                    multiplier++; // we increase the multiplier every time we change the page
                    // and are still in the same "chapter". (muliplier -> 2,3, 4,5, ...)
                }
                if(j==page) //j is a task number. If a task number equals to a page number then our counter increases 
                    count++;
            }
            page++; //after checking for a chapter, we move to the next page, and start looking there for a special task
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = workbook(n, k, arr);
        System.out.println(result);
        in.close();
    }
}
