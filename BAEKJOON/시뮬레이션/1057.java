//백준 알고리즘 1057번 : 토너먼트
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	int l = sc.nextInt();
    	int cnt = 1;
    	while(true) {
    		if((k%2==0 && k-l==1) || (l%2==0 && l-k==1)) 
    			break;
    		
    		if(k%2==0)
        		k /= 2;
        	else
        		k = k/2 +1;
        	
        	if(l%2==0)
        		l /= 2;
        	else
        		l = l/2 +1;
        	
        	cnt++;	
    	}
    	System.out.println(cnt);
    }
}
