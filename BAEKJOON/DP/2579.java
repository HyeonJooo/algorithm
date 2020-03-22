//백준 알고리즘 2579번 : 계단 오르기
import java.io.*;
import java.util.*;
public class Main {
	static int[] arr = new int[301];
	static int[] ans = new int[301];
	static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i<=n; i++) {
        	arr[i] = sc.nextInt();
        }
        dp();
    }
    
    static void dp() {
    	ans[1] = arr[1];
    	ans[2] = arr[1]+arr[2];
    	
    	for(int i = 3; i<=n; i++) {
    		ans[i] = Math.max(ans[i-3] + arr[i-1] + arr[i], ans[i-2] + arr[i]);
    	}
    	System.out.println(ans[n]);
    }
}
