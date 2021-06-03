import java.io.*;
import java.util.*;

public class Main {

    static String[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[] visit = new boolean[26];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        arr = new String[r][c];

        for(int i = 0; i<r; i++) {
            String s = sc.next();
            arr[i] = s.split("");
        }

        dfs(0,0, 1);

        System.out.println(answer);
    }

    static void dfs(int x, int y, int depth) {
        visit[arr[x][y].charAt(0) - 'A'] = true;
        if(depth > answer)
            answer = depth;

        for(int i = 0 ; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx <arr.length && ny<arr[0].length) {
                if(!visit[arr[nx][ny].charAt(0) - 'A']) {
                    dfs(nx,ny,depth+1);
                    visit[arr[nx][ny].charAt(0) - 'A'] = false;
                }
            }
        }
    }
}
