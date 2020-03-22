//백준 알고리즘 1439번 : 뒤집기
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	String[] arr = s.split("");
    	int cnt1 = 0, cnt0 = 0;
    	
    	if(arr[0].equals("0"))
    		cnt0++;
    	else
    		cnt1++;
    	
    	for(int i = 1; i<arr.length; i++) {
    		if(!arr[i-1].equals(arr[i])) {
    			if(arr[i].equals("0"))
    				cnt0++;
    			else
    				cnt1++;
    		}
    	}
    	System.out.println(Math.min(cnt0, cnt1));
    }
}
