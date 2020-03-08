//백준 알고리즘 1526번 : 가장 큰 금민수
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int insert = sc.nextInt();
        int value = 0;
        Queue<Integer> q = new LinkedList<Integer>();
		if(insert >= 4) {
			q.add(4);
			value = 4;
		}
		if(insert >= 7) {
			q.add(7);
			value = 7;
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			now *= 10;
			now += 4;
			
			if(now <= insert) {
				value = now;
				q.add(now);
			}
			now += 3;
			if(now <= insert) {
				value = now;
				q.add(now);
			}
		}
		System.out.println(value);

    }
}
