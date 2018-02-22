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

    static int migratoryBirds(int n, int[] ar) {
        // Complete this function
        int mxbird=ar[0], mxcount=-1;
        int[] count = new int[5];
        for(int i=0; i<n; i++){
            if(ar[i]==1)
                count[0]++;
            else if(ar[i]==2)
                count[1]++;
            else if(ar[i]==3)
                count[2]++;
            else if(ar[i]==4)
                count[3]++;
            else
                count[4]++;
        }
        
        for(int i=0; i<count.length; i++){
            if(mxcount<count[i]){
                mxcount=count[i];
                mxbird=i+1;
            }
            else if(mxcount==count[i]){
                if(mxbird>i+1)
                    mxbird=i+1;
            }
        }
        return mxbird;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
