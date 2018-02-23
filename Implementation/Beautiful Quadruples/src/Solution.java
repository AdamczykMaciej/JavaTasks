import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		int D = in.nextInt();
		//int count = 0;
		int[] ar = { A, B, C, D };
		// bubble sort
		// for(int i=0; i<ar.length; i++){
		// for(int j=1; j<ar.length-i; j++){
		// if(ar[j-1]>ar[j]){
		// int temp=ar[j+1];
		// ar[j+1]=ar[j];
		// ar[j]=temp;
		// }
		// }
		// }
		// optimized quick sort
//		Arrays.sort(ar);
//		Set<String> list = new HashSet<String>();
//		for (int a = 1; a <= ar[0]; a++) {
//			for (int i = 1; i <= ar[1]; i++) {
//				for (int j = 1; j <= ar[2]; j++) {
//					for (int k = 1; k <= ar[3]; k++) {
//						if ((a ^ i ^ j ^ k) != 0) {
//							int[] temp = { a, i, j, k };
//							Arrays.sort(temp);
//							String s = temp[0] + " " + temp[1] + " " + temp[2] + " " + temp[3];
//							list.add(s);
//						}
//					}
//				}
//			}
//		}
//		for (String a : list) {
//			// System.out.print(a+" "+a.hashCode()+"");
//			// System.out.println();
//			count++;
//		}
//		System.out.println(count);
		int[] m = new int[] {A, B, C, D};
        Arrays.sort(m); //sorted (quick sort)
        
        long[][] count = new long[3001][4096];
        
        for (int i=1; i<=m[0]; i++) {
            for (int j=i; j<=m[1]; j++) {
                count[j][i ^ j] ++;
            }
        }
//        for(int i=0; i<count.length; i++) {
//        	System.out.println(count[2][i]);
//        }
        /*
         * We fill in here our array with intermediate results
         * Like:
         * For e.g. 1 2 3 4
         * [0|0|0|0|0|0|0|..]
         * [1|0|0|0|0|0|0|..]
         * [0|0|0|1|0|0|0|..]
         * index 0 filled when j=1.
         * index 3 filled when j=2.
         * Index 0 has the result of i^j==0. Then it is not a beautiful quadruple.
         * Here we have 1 such case.
         * [0|0|0|0|0|0|0|..]
         * ...
         */
        for (int i=0; i<4096; i++) { /*4096, because 3000 = 12 bits. To satisfy A^B^C^D we need 13 bits
        	 cause 111111111111^111111111111^1111111111111111^1111111111111111=10000000000000000 <- 13 bits
        	 */
            for (int j=1; j<=3000; j++) {
                count[j][i] += count[j-1][i];
            }
        }
        //count[1][3]=1;
        /*
         * Here we populate our rows. Now in our case we have:
         * [0|0|0|0|0|0|0|..]
         * [1|0|0|0|0|0|0|..] Here we don't have 1 in the 3rd position. That's intentionally. It will eliminate "duplicates" in the 1st iteration (see 2nd loop below). That's a special case.
         * [1|0|0|1|0|0|0|..]
         * [1|0|0|1|0|0|0|..] 
         * [1|0|0|1|0|0|0|..]
         * ...
         */
        long[] sum = new long[3001]; // the size is important (task's condition) :)
        for (int j=1; j<=3000; j++) {
            for (int i=0; i<4096; i++) {
                sum[j] += count[j][i]; // number of pairs A and B
                //we count "1"s in our array.
            }
        }
        
        long res=0; //result
        for (int i=1; i<=m[2]; i++) {
        	System.out.println("i= "+i);
            for (int j=i; j<=m[3]; j++) { /*j=i to avoid duplicates -> 1211, 1112 etc.
            	how do we do it? We set "j" to "i". Thanks to that we will skip the "duplicates".
            	i=2, j=2; i=3, j=3; i=4, j=4; There isn't any way to get i=1 j=2 AND i=2 j=1 .
             	*/
                res += sum[i] - count[i][i^j]; 
                /*result = all permutations - permutations when (A^B==0 && C^D==0) || (A^B=x && 					C^D==x), so we have to find out how much we have to subtract. We subtract 					whenever we find "1" in our array.
                 * 
                 */
                System.out.println(sum[i]+"-"+count[i][i^j]+"= "+(sum[i]-count[i][i^j]));
            }
        }
        System.out.println(res);
	}
}
