import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	int[] arr = new int[n+1];
    	for(int i = 1; i<=n; i++) {
    		arr[i] = i;
    	}
    	
    	for(int i = 0 ; i<m; i++) {
    		int num1 = sc.nextInt();
    		int num2 = sc.nextInt();
    		int tmp = arr[num1];
    		arr[num1] = arr[num2];
    		arr[num2] = tmp;
    	}
    	for(int i = 1; i<=n; i++) {
    		System.out.print(arr[i] + " ");
    	}System.out.println("");
    }
}
