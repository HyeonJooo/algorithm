//백준 알고리즘 2812번 : 크게 만들기
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        char[] arr = new char[n];
        String s = sc.next();
        int t = 0;
        char tmp;
        for(int i = 0 ; i<n; i++) {
        	tmp = s.charAt(i);
        	while(k>0 && t>0 && arr[t-1] < tmp) {
        		t--;
        		k--;
        	}
        	arr[t] = tmp;
        	t++;
        }
        t -= k;
        for(int i = 0; i<t; i++) {
        	System.out.print(arr[i]);
        }
    }
}
