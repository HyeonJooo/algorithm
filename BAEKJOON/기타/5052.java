//백준 알고리즘 5052번 : 전화번호 목록
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt();
    	for(int a= 0; a<t; a++) {
        	int n = sc.nextInt();
        	String[] phone_book = new String[n];
        	for(int i = 0; i<n; i++) {
        		phone_book[i] = sc.next();
        	}
        	Arrays.sort(phone_book);
        	int check = 1;
        	for(int i = 0; i<phone_book.length-1; i++) {
        		if(phone_book[i+1].startsWith(phone_book[i])) {
        			System.out.println("NO");
        			check = 0;
        			break;
        		}
        	}
        	if(check == 1)
        		System.out.println("YES");
    	}
    }
}
