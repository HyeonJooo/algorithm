//백준 알고리즘 2161번 : 카드1
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> ansqueue = new LinkedList<Integer>();
        for(int i = 1; i<=n; i++) {
        	queue.offer(i);
        }
        
        while(queue.size()!=1) {
        	ansqueue.offer(queue.poll());//제일 위에있는 카드를 버린다
        	int tmp = queue.poll();//그다음 제일 위에있는 카드를 
        	queue.offer(tmp); //가장 밑으로 옮긴다
        }
        ansqueue.offer(queue.peek());//마지막에 남은 카드
        
        for(int i : ansqueue)
        	System.out.print(i + " ");
    }
}
