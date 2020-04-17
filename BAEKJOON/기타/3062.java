//백준 알고리즘 3062번 : 수 뒤집기
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt();
    	for(int i = 0 ; i<t; i++) {
    		String s = sc.next();
    		String reverse = new StringBuffer(s).reverse().toString();
    		int num1 = Integer.parseInt(s);
    		int num2 = Integer.parseInt(reverse);
    		int num3 = num1 + num2;
    		String tmp1 = Integer.toString(num3);
    		String tmp2 = new StringBuffer(tmp1).reverse().toString();
    		if(tmp1.equals(tmp2))
    			System.out.println("YES");
    		else
    			System.out.println("NO");
    	}
    }
}
