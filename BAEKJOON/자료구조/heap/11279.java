백준 알고리즘 11279번 : 최대힙
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i = 0 ; i<n; i++) {
        	int num = sc.nextInt();
        	if(num==0) {
        		if(queue.isEmpty()) {
        			System.out.println(0);
        		}
        		else {
        			System.out.println(queue.poll());
        		}
        	}
        	else {
        		queue.offer(num);
        	}
        }
    }
}
