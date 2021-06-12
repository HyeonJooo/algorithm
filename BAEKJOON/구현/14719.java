import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        boolean[][] block = new boolean[h][w];

        for(int i = 0; i<w; i++) {
            int height = sc.nextInt();
            int idx = h-1;
            while (height != 0) {
                block[idx][i] = true;
                idx--;
                height--;
            }
        }

        int ans = 0;
        int cnt = 0;
        for(int i = h-1; i>=0; i--) {
            for(int j = 1; j<w; j++) {
                if(j != w-1 && !block[i][j]) {
                    cnt++;
                    continue;
                }

                else {
                    int idx = j;
                    if(block[i][idx] && block[i][idx-cnt-1]) {
                        ans += cnt;
                    }
                    cnt = 0;
                }
            }
        }
        System.out.println(ans);
    }
}
