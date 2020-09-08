import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        int pushNum = 0;
        for(int i = 0; i<n; i++) {
        	String command = sc.next();
        	if(command.equals("push")) {
        		pushNum = sc.nextInt();
        		queue.add(pushNum);
        	}
        	else {
        		if(command.equals("pop")) {
        			if(queue.isEmpty())
        				System.out.println(-1);
        			else
        				System.out.println(queue.poll());
        		}
        		
        		else if(command.equals("size")) {
        			System.out.println(queue.size());
        		}
        		
        		else if(command.equals("empty")) {
        			if(queue.isEmpty())
        				System.out.println(1);
        			else
        				System.out.println(0);
        		}
        		else if(command.equals("front")) {
        			if(queue.isEmpty())
        				System.out.println(-1);
        			else
        				System.out.println(queue.peek());
        		}
        		else {
        			if(queue.isEmpty())
        				System.out.println(-1);
        			else
        				System.out.println(pushNum);
        		}
        	}
        }
    }
}
