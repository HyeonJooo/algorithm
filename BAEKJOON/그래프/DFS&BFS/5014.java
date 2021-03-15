import java.io.*;
import java.util.*;
public class Main {
    static int[] updown;
    static boolean[] visit;
    static int f,s,g,u,d;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        f = sc.nextInt(); //꼭대기층
        s = sc.nextInt(); //현재위치
        g = sc.nextInt(); //가려는곳
        u = sc.nextInt();
        d = sc.nextInt();

        updown = new int[2];
        updown[0] = u;
        updown[1] = d * (-1);
        visit = new boolean[2000001];
        if(s==g) {
            System.out.println(0);
            System.exit(0);
        }
        bfs();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int cnt = 0;
        visit[s] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int a = 0; a<size; a++) {
                int qx = queue.peek();
                queue.poll();

                for(int i = 0; i<2; i++) {
                    int nx = qx + updown[i];
                    if(nx == g) {
                        System.out.println(cnt+1);
                        System.exit(0);
                    }

                    if(nx>2000000) {
                        System.out.println("use the stairs");
                        System.exit(0);
                    }

                    if(nx<1)//범위 밖이면 건너뜀
                        continue;

                    if(visit[nx])//이미 방문한 곳이면 건너뜀
                        continue;

                    if(nx > f)
                        continue;

                    queue.add(nx);
                    visit[nx] = true;
                }
            }
            cnt++;
        }
        System.out.println("use the stairs");
    }
}
