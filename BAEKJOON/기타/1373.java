//백준 알고리즘 1373번 : 2진수 8진수
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	int num = s.length();
    	if(num % 3 == 1)
    		System.out.print(s.charAt(0));
    	else if(num % 3 == 2)
    		System.out.print((s.charAt(0)-'0')*2 + (s.charAt(1)-'0'));
    	
    	for(int i = num%3; i<num; i+=3) {
    		System.out.print((s.charAt(i)-'0')*4 + (s.charAt(i+1)-'0')*2 + (s.charAt(i+2)-'0'));
    	}
    	System.out.println("");
    }
}
