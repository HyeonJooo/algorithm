import java.io.*;
import java.util.*;

class Emoticon {
    int screen;
    int clip;
    int cnt;

    public Emoticon(int screen, int clip, int cnt) {
        this.screen = screen;
        this.clip = clip;
        this.cnt = cnt;
    }
}

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        boolean[][] visit = new boolean[n+1][n+1]; //[화면에 출력된 개수][클립에 복사된 개수]
        Queue<Emoticon> queue = new LinkedList<>();
        queue.add(new Emoticon(1,0,0));

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int a = 0; a<size; a++) {
                Emoticon emoticon = queue.poll();
                if(emoticon.screen == n) {
                    System.out.println(emoticon.cnt);
                    System.exit(0);
                }

                //복사
                queue.add(new Emoticon(emoticon.screen, emoticon.screen, emoticon.cnt+1));

                //붙여넣기
                if(emoticon.clip != 0 && emoticon.screen+ emoticon.clip <= n
                        && emoticon.clip <= n && !visit[emoticon.screen+ emoticon.clip][emoticon.clip]) {
                    visit[emoticon.screen+ emoticon.clip][emoticon.clip] = true;
                    queue.add(new Emoticon(emoticon.screen+emoticon.clip, emoticon.clip, emoticon.cnt+1));
                }

                //삭제
                if(emoticon.screen-1 > 0 && emoticon.clip <= n && !visit[emoticon.screen-1][emoticon.clip]) {
                    visit[emoticon.screen-1][emoticon.clip] = true;
                    queue.add(new Emoticon(emoticon.screen-1, emoticon.clip, emoticon.cnt+1));
                }
            }
        }
    }
}
