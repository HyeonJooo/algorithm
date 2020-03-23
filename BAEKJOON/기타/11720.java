//백준 알고리즘 11720번 : 숫자의 합
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt();
		String[] arr = new String[n];
		String s = sc.next();
		arr = s.split("");
		int sum = 0;
		for(int i = 0; i<arr.length; i++) {
			int a = Integer.parseInt(arr[i]);
			sum += a;
		}
		System.out.println(sum);
	}
}
