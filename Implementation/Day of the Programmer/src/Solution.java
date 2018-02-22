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

    static String solve(int year){
        // Complete this function
        if(year>=1919){
            if(year%400==0 || (year%4==0 && year%100!=0))
                return "12.09."+year;
            else
                return "13.09."+year;
        }
        else if(year<=1917){
            if(year%4==0)
                 return "12.09."+year;
            else
                 return "13.09."+year;
        }
        else{
            int m=3, d=256-32-15, month=31;
            boolean flag=false;
            while(true){
                if(d>month){
                    d-=month;
                    m++;
                    if(flag==false){
                        month--;
                        flag=true;
                    }
                    else{    
                        month++;
                        flag=false;
                    }
                }
                else
                    break;
            }
            return d+".0"+m+".1918";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
}
