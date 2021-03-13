import java.io.*;
import java.util.*;
public class Main {
    static int[][] arr;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        arr = new int[3][3];
        int num = 0;
        for(int i = 0 ; i<3; i++) {
            for(int j = 0; j<3; j++) {
                int k = sc.nextInt();
                if(k == 0)
                    k = 9;
                arr[i][j] = k;
                num = (num*10) + k;
            }
        }
        bfs(num);
    }

    public static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> m = new HashMap<>();
        queue.offer(num);
        m.put(num, 0);

        while(!queue.isEmpty()) {
            int nowInt = queue.poll();
            String now = String.valueOf(nowInt);
            int zero = now.indexOf("9");
            int x = zero/3; //2차원 배열에서 0의 x좌표
            int y = zero%3; //2차원 배열에서 0의 y좌표

            for(int i = 0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int to = nx*3 + ny; //이동할 1차원 배열 인덱스

                if(nx<0 || ny<0 || nx>=3 || ny>=3)
                    continue;

                StringBuilder next = new StringBuilder(now);
                char temp = next.charAt(to);
                next.setCharAt(to, '9');
                next.setCharAt(zero, temp);
                int nextNum = Integer.parseInt(next.toString());

                if(!m.containsKey(nextNum)) {
                    m.put(nextNum, m.get(nowInt) + 1);
                    queue.add(nextNum);
                }
            }
        }

        if(m.containsKey(123456789))
            System.out.println(m.get(123456789));
        else
            System.out.println(-1);
    }
}
