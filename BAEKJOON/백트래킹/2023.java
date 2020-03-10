//백준 알고리즘 2023번 : 신기한 소수
import java.io.*;
import java.util.*;
public class Main {
	static int n;
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	re(1,2);
    	re(1,3);
    	re(1,5);
    	re(1,7);
    }
    static void re(int cnt, int num) {
    	if(cnt == n) {
    		if(isprime(num))
    			System.out.println(num);
    		return;
    	}
    	for(int i = 1; i<10; i++) {
    		if(i==2 || i==4 || i==6 || i==8)
    			continue;
    		if(isprime(num*10 + i))
    			re(cnt+1, num*10+i);
    	}
    }
    
    static boolean isprime(int num) {//소수 판별
    	for(int i = 2; i<=num/2; i++) {
    	if(num % i == 0)
    		return false;
    	}
    	return true;
    }
}
