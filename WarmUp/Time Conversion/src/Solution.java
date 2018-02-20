import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
 * Given a time in 12-hour AM/PM format, convert it to military (-hour) time.
 */
public class Solution {

    static String timeConversion(String s) {
        // Complete this function
    	String[] ar = s.split(":");
    	int hrs;
    	String converted="";
    	if(s.matches("^12.*PM$")) {
    		ar[ar.length-1]=ar[ar.length-1].replaceAll("PM", "");
    		for(int i=0; i<ar.length; i++) {
    			if(i==ar.length-1) {
    				converted+=ar[i];
    				break;
    			}
    			converted+=ar[i]+":";
    		}
    		return converted;
    	}
    	if(s.matches("^12.*AM$")){
        	ar[ar.length-1]=ar[ar.length-1].replaceAll("AM", "");
        	ar[0]="00";
        	for(int i=0; i<ar.length; i++) {
        		
        		if(i==ar.length-1) {
    				converted+=ar[i];
    				break;
    			}
        		converted+=ar[i]+":";
        	}
        	return converted;
        }
    		
    	if(s.matches("^.*PM.*$")) {
    		hrs=Integer.parseInt(ar[0])+12;
    		ar[0]=""+hrs;
    	}
    	
    	for(int i=0; i<ar.length; i++) {
    		if(i==ar.length-1) {
    			ar[i]=ar[i].replaceAll("PM", "");
    			ar[i]=ar[i].replaceAll("AM", "");
    			converted+=ar[i];
    			break;
    		}
    		converted+=ar[i]+":";
    	}
    	return converted;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
