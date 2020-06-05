//백준 알고리즘 11286번 : 절댓값 힙
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new PriorityQueue<>();
        Queue<Integer> minusqueue = new PriorityQueue<>();
        
        for(int i = 0 ; i<n; i++) {
        	int num = sc.nextInt();
        	
        	if(num==0) {
        		if(!queue.isEmpty() && minusqueue.isEmpty())//음수값이 비어있으면
        			System.out.println(queue.poll());//양수출력
        		
        		else if(queue.isEmpty() && !minusqueue.isEmpty()) //양수가 비어있으면
        			System.out.println(-1 * minusqueue.poll());//음수출력
        		
        		else if(queue.isEmpty() && minusqueue.isEmpty())//둘다비었으면
        			System.out.println(0);
        		
        		else {//둘다 안비어있으면
        		if(queue.peek() < minusqueue.peek())
        			System.out.println(queue.poll());
        		
        		else
        			System.out.println(-1 * minusqueue.poll());
        		}
        	}
        		
        	else {
        		if(num  > 0)
        			queue.offer(num);
        		else
        			minusqueue.offer(-1 * num);
        	}
        }
    }
}
