import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i<n; i++) {
            pq.offer(sc.nextInt());
        }

        for(int i = 1; i<n; i++) {
            for(int j = 0 ; j<n; j++) {
                int num = sc.nextInt();
                if(pq.peek() < num) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        System.out.println(pq.poll());
    }
}
