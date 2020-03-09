import java.util.*;
public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt();
		int count = 0;
		int d1,d2;
		
		for(int i = 1; i<=n; i++) {
			int a = i;
		if(i>=100 && i<1000) {
			while(a != 0) {
				d1 = (a%10)-(a/10%10);
				a /= 10;
				d2 = (a%10)-(a/10%10);
				if(d1 == d2) {
					count++;
					break;
				}
				else
					break;
			}
		}
		else if(i<100)
			count++;
		
		else
			break;
		}
		System.out.println(count);
	}
}
