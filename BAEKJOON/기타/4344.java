//백준 알고리즘 4344번 : 평균은 넘겠지
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int a = sc.nextInt();
		for(int i = 0; i<a; i++) {
			int b = sc.nextInt();
			int[] arr = new int[b];
			float avg = 0.0f, count = 0.0f;;	
			
			for(int j = 0; j<b; j++) {
				arr[j] = sc.nextInt();
				avg += arr[j];
			}avg = avg/b;
			
			for(int k = 0; k<b; k++) {
				if(avg<arr[k])
					count++;
				else
					continue;
			}
			System.out.printf("%.3f%%\n", count/b*100);
		}
	}
}
