import java.io.*;
import java.util.*;
public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		long answer = 0;
		for(int i = 0 ; i<n; i++) {
			answer++;
			if(arr[i]-b > 0) {
				int num1 = (arr[i]-b)/c;
				int num2 = (arr[i]-b)%c;
				if(num2 == 0)
					answer += num1;
				else
					answer += num1+1;
			}
		}
		System.out.println(answer);
	}
}
