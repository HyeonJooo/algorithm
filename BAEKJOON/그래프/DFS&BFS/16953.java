import java.io.*;
import java.util.*;

public class Main {

    static long a,b;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        if(a == b) {
            System.out.println(1);
            System.exit(0);
        }

        bfs(a);
        System.out.println(-1);
    }

    static void bfs(long a) {
        Queue<Long> queue = new LinkedList<>();
        queue.add(a);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int si = 0; si<size; si++) {
                long num = queue.poll();
                if(num == b) {
                    System.out.println(cnt+1);
                    System.exit(0);
                }

                long num1 = num*2;
                long num2 = num*10 + 1;

                if(num1<=b) {
                    queue.add(num1);
                }
                if(num2<=b) {
                    queue.add(num2);
                }
            }
            cnt++;
        }
    }
}
