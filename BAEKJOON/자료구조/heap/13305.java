//백준 알고리즘 13305번 : 주유소
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Long> pq = new PriorityQueue<>();
        long[] city = new long[n-1];
        long[] oil = new long[n];
        long answer = 0;
        
        for(int i = 0; i<n-1; i++) {
        	city[i] = sc.nextLong();
        }
        for(int i = 0; i<n; i++) {
        	oil[i] = sc.nextLong();
        }
        
        for(int i = 0 ; i<n-1; i++) {
        	pq.add(oil[i]);
        	answer += pq.peek() * city[i];
        }
        
        System.out.println(answer);
        
    }
}
