//백준 알고리즘 1551번 : 수열의 변화
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	int[] arr = new int[n];
    	String s = sc.next();
    	String[] st;
    	st = s.split(",");
    	for(int i = 0; i<st.length; i++) {
    		arr[i] = Integer.parseInt(st[i]);
    	}
    	for(int i = 0 ; i<k; i++) {
    		for(int j = 0; j<arr.length-1; j++) {
    			arr[j] = arr[j+1] - arr[j];
    		}
    	}
    	for(int i = 0; i<arr.length-k; i++) {
    		System.out.print(arr[i]);
    		if(i != arr.length-k-1)
    			System.out.print(",");
    	}
    }
}
