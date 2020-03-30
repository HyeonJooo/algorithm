//백준 알고리즘 2979번 : 트럭 주차
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[100];
        for(int i = 0 ; i<3; i++) {
        	int num1 = sc.nextInt();
        	int num2 = sc.nextInt();
        	for(int j = num1; j<num2; j++) {
        		arr[j]++;
        	}
        }
        int ans = 0;
        for(int i = 1; i<100; i++) {
        	if(arr[i] == 1)
        		ans += a;
        	else if(arr[i] == 2)
        		ans += 2*b;
        	else if(arr[i] == 3)
        		ans += 3*c;
        	else
        		continue;
        }
        System.out.println(ans);
    }
}
