import java.io.*;
import java.util.*;

/*
 * Toby is the head of social media at an Extremely Anonymous company. His intern has (finally) worked out the change in twitter followers for the last n days. A positive number indicated they gained that many followers. A negative number means they lost that many.

However, Toby is a busy guy. He only cares about 3 numbers.

What change in followers would need to happen tomorrow such that they are back where they started n days ago?
What was the worst change in their follower count?
What was the best change in their follower total?
Your task is to work out these numbers, and report them back to Toby.

Input Format

The first line contains a single integer n The second line contains n space-separated integers, each representing the change in followers for that day.
 */

/**
 * 
 * @author Maciej Adamczyk
 *
 */
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.next());
        int sum=Integer.parseInt(scan.next()), mx=sum, min=sum;
        while(scan.hasNext()){
            int next=Integer.parseInt(scan.next());
            sum+=next;
            if(next>mx) mx=next;
            if(next<min) min=next;
        }
        System.out.print(-sum+" ");
        System.out.print(min+" ");
        System.out.print(mx);
        
    }
}