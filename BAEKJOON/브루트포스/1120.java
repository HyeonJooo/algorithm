//백준 알고리즘 1120번 : 문자열
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       String a = sc.next();
       String b = sc.next();
       String[] a1 = a.split("");
       String[] b1 = b.split("");
       int gap = b1.length - a1.length;
       int num = a1.length;
       
       for(int i = 0; i<=gap; i++) {
    	   int k = 0;
    	   for(int j = 0; j<a1.length; j++) {
    		   if(!a1[j].equals(b1[i+j]))
    			   k++;
    	   }
    	   if(num>k)
    		   num = k;
       }
       System.out.println(num);
    }
}
