//백준 알고리즘 1748번 : 수 이어 쓰기 1
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n  = sc.nextInt();
    	long answer = 0;
    	for(int i = 1; i<=n; i++) {
    		if(i<10)
    			answer++;
    		else if(i>=10 && i<100)
    			answer += 2;
    		else if(i>=100 && i<1000)
    			answer += 3;
    		else if(i>=1000 && i<10000)
    			answer += 4;
    		else if(i>=10000 && i<100000)
    			answer += 5;
    		else if(i>=100000 && i<1000000)
    			answer += 6;
    		else if(i>=1000000 && i<10000000)
    			answer += 7;
    		else if(i>=10000000 && i<100000000)
    			answer += 8;
            else
                answer += 9;
    	}
    	System.out.println(answer);
    }
}
