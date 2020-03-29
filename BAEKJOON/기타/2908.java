//백준 알고리즘 2908번 : 상수
import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		String a = sc.next();
		String b = sc.next();
		StringBuffer sb1 = new StringBuffer(a);
		StringBuffer sb2 = new StringBuffer(b);
		a = sb1.reverse().toString();
		b = sb2.reverse().toString();
		
		int ca = Integer.parseInt(a);
		int cb = Integer.parseInt(b);

		if(ca>cb)
			System.out.println(ca);
		else
			System.out.println(cb);
	}
}
