//백준 알고리즘 9517번 : 아이 러브 크로아티아
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int k = sc.nextInt();
    	int n = sc.nextInt();
    	int[] time = new int[n];
    	String[] answer = new String[n];
    	for(int i = 0 ; i<n; i++) {
    		time[i] = sc.nextInt();
    		answer[i] = sc.next();
    	}
    	int cnt = 210;
    	int i = 0;
    	while(true) {
    		cnt -= time[i];
    		if(cnt < 0)
    			break;
    		if(answer[i].equals("T")) {
    			k++;
    		if(k==9)
    			k = 1;
    		}	
    		i++;
    	}
    	System.out.println(k);
    }
}
