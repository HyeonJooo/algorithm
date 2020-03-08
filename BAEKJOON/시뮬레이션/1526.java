//백준 알고리즘 1526번 : 가장 큰 금민수
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(4);
		int num = 4;
		
		if(n >= 7) {
			queue.add(7);
			num = 7;
		}
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			tmp *= 10;
			tmp += 4;
			
			if(tmp <= n) {
				num = tmp;
				queue.add(tmp);
			}
			tmp += 3;
			if(tmp <= n) {
				num = tmp;
				queue.add(tmp);
			}
		}
		System.out.println(num);
    }
}
