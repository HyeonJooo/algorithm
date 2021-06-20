import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean[][] visit = new boolean[101][101];
        for(int i = 0; i<4; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for(int j = x1; j<x2; j++) {
                for(int k = y1; k<y2; k++) {
                    if(!visit[j][k])
                        visit[j][k] = true;
                }
            }
        }
        int answer = 0;
        for(int i = 1; i<101; i++) {
            for(int j = 1; j<101; j++) {
                if(visit[i][j])
                    answer++;
            }
        }
        System.out.println(answer);
    }
}
