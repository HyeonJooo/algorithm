//백준 알고리즘 2747번 : 피보나치 수
import java.io.*;
import java.util.*;
public class Main {   
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       long a = 0;
       long b = 1;
       long c = 0;
       
       for(int i = 0; i<n; i++) {
    	   c = a+b;
    	   b = a;
    	   a = c;
       }
       
       System.out.println(c);
    }
}
