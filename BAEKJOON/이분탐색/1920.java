//백준 알고리즘 1920번 : 수 찾기
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i <n; i++) {
        	arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] num = new int[m];
        for(int i = 0 ; i<m; i++) {
        	num[i] = sc.nextInt();
        }
        Arrays.sort(arr);       
        
        for(int i = 0 ; i<m; i++) {
            int mid = 0;        	
            int left = 0;
            int right = arr.length-1;
        	while(right >= left) {
        		mid = (left + right) /2;	
       	
        	if(num[i] == arr[mid]) {
        		System.out.println(1);
        		break;
        	}        	
        	if(num[i] < arr[mid])
        		right = mid-1;
        	else
        		left = mid+1;
        	}
        	if(right < left)
        		System.out.println(0);
        }     
    }
}
