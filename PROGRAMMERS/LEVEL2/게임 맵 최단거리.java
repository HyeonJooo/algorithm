import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[][] arr = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(arr));
    }

    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    public static int solution(int[][] maps) {
        int answer = 1;
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visit = new boolean[maps.length][maps[0].length];

        queue.offer(new int[]{0,0});
        visit[0][0] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int a = 0; a<size; a++) {
                int qx = queue.peek()[0];
                int qy = queue.peek()[1];
                queue.poll();

                for(int i = 0; i<4; i++) {
                    int nx = qx + dx[i];
                    int ny = qy + dy[i];

                    if(nx == maps.length-1 && ny == maps[0].length)
                        return answer;

                    if(nx<0 || ny<0 || nx>= maps.length || ny>=maps[0].length)//범위 밖이면 건너뜀
                        continue;
                    if(maps[nx][ny] != 1)
                        continue;
                    if(visit[nx][ny])//이미 방문한 곳이면 건너뜀
                        continue;

                    queue.offer(new int[] {nx,ny});
                    visit[nx][ny] = true;
                }
            }
            answer++;
        }
        return -1;
    }
}
