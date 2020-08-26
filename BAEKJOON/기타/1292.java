import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int[] arr = new int[b+1];
		int idx = 0;
		for(int i = 1; i<=b; i++) {
			int check = 0;
			for(int j = i; j<i+i; j++) {
				idx++;
				if(idx > b) {
					check = 1;
					break;					
				}
				if(arr[idx] != 0) {
					check = 1;
					break;
				}
				arr[idx] = i;
			}
			if(check == 1)
				break;
		}
		int sum = 0;
		for(int i = a; i<=b; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
