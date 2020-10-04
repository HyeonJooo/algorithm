import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		while(n>0) {
			if(n%5==0) {
				cnt = cnt+ n/5;
				n = 0;
				break;
			}
			else {
				n -= 2;
				cnt++;
			}
		}
		if(n==0)
			System.out.println(cnt);
		else
			System.out.println(-1);
	}
}
