//백준 알고리즘 2857번 : FBI
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	StringBuilder ans = new StringBuilder();
    	boolean check = true;
    	for(int i = 0 ; i<5; i++) {
    		String s = sc.next();
    		for(int j = 0 ; j<s.length()-2; j++) {
    			String tmp = "";
    			for(int k = j; k<j+3; k++) {
    				tmp += s.charAt(k);
    			}
    			if(tmp.equals("FBI")) {
    				ans.append(i+1 + " ");
    				check = false;
    				break;
    			}
    		}
    	}
    	if(check == true)
    		System.out.println("HE GOT AWAY!");
    	else
    		System.out.println(ans);
    }
}
