//2018 고려대학교 프로그래밍 경시대회
//백준 알고리즘 16680번 : 안수빈수
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt();
    	for(int i = 0 ; i<t; i++) {
    		long n = sc.nextLong();
    		while(n <= 1000000000000000000L) {
    			int sum = 0;	
        		long num = n;
    			while(num != 0) {
        			sum += num%10;
        			num /= 10;
        		}
        		if(sum % 2 == 1) {
        			System.out.println(n);
        			break;
        		}
        		else {
        			n += n;
        		}
    		}
    		if(n >= 1000000000000000000L)
    			System.out.println(-1);
    	}
    }
}
