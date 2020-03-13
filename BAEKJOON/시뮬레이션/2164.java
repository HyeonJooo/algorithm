//백준 알고리즘 2164번 : 카드2
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 1; i<=n; i++) {
        	queue.offer(i);
        }
        
        while(queue.size()!=1) {
        	queue.poll();//제일 위에있는 카드를 버린다
        	int tmp = queue.poll();//그다음 제일 위에있는 카드를 
        	queue.offer(tmp); //가장 밑으로 옮긴다
        }
        
        System.out.println(queue.poll());
    }
}
