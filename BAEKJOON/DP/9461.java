//백준 알고리즘 9461번 : 파도반 수열
import java.io.*;
import java.util.*;
public class Main {
	static long[] arr = new long[101];
	
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i<t; i++) {
            long n = sc.nextInt();
            System.out.println(dp(n));        	
        }

    }
    
    static long dp(long n) {
    	if(n==1)
    		return 1;
    	if(n==2)
    		return 1;
    	if(n==3)
    		return 1;
    	if(arr[(int) n] != 0)
    		return arr[(int) n];
    	
    	return arr[(int) n] = (dp(n-2) + dp(n-3));
    }
}
