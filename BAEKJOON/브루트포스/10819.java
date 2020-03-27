//백준 알고리즘 10819번 : 차이를 최대로
import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       n = sc.nextInt();
       int[] arr = new int[n];
       for(int i = 0 ; i<n; i++) {
    	   arr[i] = sc.nextInt();
       }
       permutation(arr, 0);
       System.out.println(max);
    
    }
    static void permutation(int[] arr, int depth) {
    	if(depth == n) {
    		cal(arr);
    		return;
    	}
    	
    	for(int i = depth; i<n; i++) {
    		int tmp = arr[i];
    		arr[i] = arr[depth];
    		arr[depth] = tmp;
    		
    		permutation(arr, depth+1);
    		
    		int temp = arr[i];
    		arr[i] = arr[depth];
    		arr[depth] = temp;
    	}
    }
    static void cal(int[] arr) {
    	int sum = 0;
    	for(int i = 0 ; i<arr.length-1; i++) {
    		sum += Math.abs(arr[i+1] - arr[i]);
    	}
    	if(max < sum)
    		max = sum;
    }
}
