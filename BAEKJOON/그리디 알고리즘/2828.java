//백준 알고리즘 2828번 : 사과 담기 게임
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int j = sc.nextInt();
        
        int left = 0;
        int right = m-1;
        int count = 0;
        for(int i = 0 ; i<j; i++) {
        	int num = sc.nextInt();
        	
        	if(num > right) {
        		count += num-right;
        		right = num;
        		left = num-(m-1);
        	}
        	else if(num < left) {
        		count += left-num;
        		left = num;
        		right = num + (m-1);
        	}
        }
        System.out.println(count-1);
    }
}
