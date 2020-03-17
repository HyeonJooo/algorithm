//카카오 코드 페스티벌 2018 예선
//백준 알고리즘 15953번 : 상금 헌터
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt();
    	for(int i = 0; i<t; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		int answer = 0;
    		if(a==1)
    			answer += 5000000;
    		else if(a>=2 && a<=3)
    			answer += 3000000;    		
    		else if(a>=4 && a<=6)
    			answer += 2000000;
    		else if(a>=7 && a<=10)
    			answer += 500000;
    		else if(a>=11 && a<=15)
    			answer += 300000;
    		else if(a>=16 && a<=21)
    			answer += 100000;
    		else
    			answer += 0;
    		
    		if(b==1)
    			answer += 5120000;
    		else if(b>=2 && b<=3)
    			answer += 2560000;    		
    		else if(b>=4 && b<=7)
    			answer += 1280000;
    		else if(b>=8 && b<=15)
    			answer += 640000;
    		else if(b>=16 && b<=31)
    			answer += 320000;
    		else
    			answer += 0;    			
        	System.out.println(answer);
    	}
	}
}
