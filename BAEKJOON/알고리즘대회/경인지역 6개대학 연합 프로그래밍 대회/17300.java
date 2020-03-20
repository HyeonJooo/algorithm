//shake!2019
//백준 알고리즘 17300번 : 패턴
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int l = sc.nextInt();
   		int[] arr = new int[l];
   		boolean[] check = new boolean[10];
   		for(int i = 0 ; i<l; i++) {
    		arr[i] = sc.nextInt();
   		}
   		int mid = 0;
   		for(int i = 0 ; i<arr.length; i++) {
   	    	if(check[arr[i]] == true || l<3) {
   	    		System.out.println("NO");
   	    		System.exit(0);
   	    	}
   	    	
   	   		check[arr[i]] = true;
   	   		if(i==0)
   	   			continue;
   	   		else {
   	   			mid = (arr[i] + arr[i-1]) / 2;
   	   			if(arr[i]%2 == 0) {
   	   				if(arr[i-1]==10-arr[i] && check[mid]==false) {
   	   	    		System.out.println("NO");
   	   	    		System.exit(0);  	   					
   	   				}
   	   			}
   	   	
   	   			else {
   	   				if(arr[i-1]%2==1 && check[mid]==false && arr[i-1]!=5 && arr[i]!=5) {
   	   	    		System.out.println("NO");
   	   	    		System.exit(0);
   	   				}
   	   			}
   	   		}
   		}
   		System.out.println("YES");
    }
}
