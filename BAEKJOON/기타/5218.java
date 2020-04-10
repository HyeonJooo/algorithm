//백준 알고리즘 5218번 : 알파벳 거리
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	for(int i = 0;  i<n; i++) {
    		String s1 = sc.next();
    		String s2 = sc.next();
    		char[] st1;
    		char[] st2;
    		st1 = s1.toCharArray();
    		st2 = s2.toCharArray();
    		System.out.print("Distances: ");
    		for(int j = 0; j<s1.length(); j++) {
    			int num1 = (int)st1[j];
    			int num2 = (int)st2[j];
    			if(num1 <= num2)
    				System.out.print(num2-num1 + " ");
    			else
    				System.out.print((num2+26)-num1 + " ");
    		}
    		System.out.println("");
    	}
    }
}
