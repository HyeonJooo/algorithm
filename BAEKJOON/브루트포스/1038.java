import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 10) {
            System.out.println(n);
            System.exit(0);
        }
        if(n > 1022) {
            System.out.println(-1);
            System.exit(0);
        }

        Queue<Long> queue = new LinkedList<>();
        for(Long i = 1L; i<10; i++) {
            queue.add(i);
        }

        int cnt = 9;

        while(cnt < n) {
            Long t = queue.poll();
            Long temp = t % 10;
            for(int i = 0; i<temp; i++) {
                queue.add(t*10 + i);
                cnt++;
                if(cnt == n) {
                    System.out.println(t*10 + i);
                    break;
                }
            }
        }
    }
}
