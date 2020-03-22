//백준 알고리즘 1541번 : 잃어버린 괄호
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
    	String[] s  = sc.next().split("\\-");
    	
    	int[] arr = new int[50];
    	
    	for(int i = 0; i<s.length; i++) {
    		if(s[i].contains("+")) {
        		String[] s2 = new String[s.length];
    			s2 = s[i].split("\\+");
    			for(int j = 0; j<s2.length; j++) {
    				arr[i] += Integer.parseInt(s2[j]);
    			}
    		}
    		
    		else {
    			arr[i] = Integer.parseInt(s[i]);
    		}
    	}
    	
    	int sum = arr[0];
    	for(int i = 1; i<arr.length; i++) {
    		sum -= arr[i];
    	}
    	System.out.println(sum);
    }
}
