//백준 알고리즘 9095번 : 1,2,3 더하기
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i<t; i++) {
        	int n = sc.nextInt();
        	int[] arr = new int[n+1];
        	if(n==1)
        		System.out.println(1);
        	else if(n==2)
        		System.out.println(2);
        	else if(n==3)
        		System.out.println(4);
        	
        	else {
        		arr[1] = 1;
        		arr[2] = 2;
        		arr[3] = 4;
        		for(int j = 4; j<=n; j++) {
                	arr[j] = arr[j-3] + arr[j-2] + arr[j-1];
            	}
            	System.out.println(arr[n]);	
        	}
        }
	}
}

