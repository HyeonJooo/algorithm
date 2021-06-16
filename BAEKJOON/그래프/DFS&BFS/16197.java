import java.io.*;
import java.util.*;

class Coin {
    int x1;
    int y1;
    int x2;
    int y2;

    public Coin(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}

public class Main {

    static int n,m;
    static String[][] arr;
    static int[] dx = {0,1,-1,0};
    static int[] dy = {1,0,0,-1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new String[n][m];

        for(int i = 0 ; i<n; i++) {
            String s = sc.next();
            arr[i] = s.split("");
        }

        Queue<Coin> queue = new LinkedList<>();
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        boolean ch = false;
        for(int i = 0 ; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(!ch && arr[i][j].equals("o")) {
                    x1 = i;
                    y1 = j;
                    ch = true;
                    continue;
                }
                if(ch && arr[i][j].equals("o")) {
                    x2 = i;
                    y2 = j;
                    break;
                }
            }
        }

        queue.add(new Coin(x1,y1,x2,y2));
        int cnt = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i<size; i++) {
                Coin coin = queue.poll();

                for(int a = 0; a<4; a++) {
                    int nx1 = coin.x1 + dx[a];
                    int ny1 = coin.y1 + dy[a];
                    int nx2 = coin.x2 + dx[a];
                    int ny2 = coin.y2 + dy[a];

                    //둘 중 하나만 밖으로 떨어진 경우
                    if(((nx1<0 || ny1<0 || nx1>=n || ny1>=m) && (nx2>=0 && ny2>=0 && nx2<n && ny2<m)) ||
                            ((nx2<0 || ny2<0 || nx2>=n || ny2>=m) && (nx1>=0 && ny1>=0 && nx1<n && ny1<m))) {
                        System.out.println(cnt+1);
                        System.exit(0);
                    }

                    if(nx1>=0 && ny1>=0 && nx2>=0 && ny2>=0 && nx1<n && ny1<m && nx2<n && ny2<m) {
                        if(arr[nx1][ny1].equals("#")) {
                            nx1 = coin.x1;
                            ny1 = coin.y1;
                        }
                        if(arr[nx2][ny2].equals("#")) {
                            nx2 = coin.x2;
                            ny2 = coin.y2;
                        }
                        queue.add(new Coin(nx1, ny1, nx2, ny2));
                    }
                }
            }
            cnt++;
            if(cnt == 10) {
                System.out.println(-1);
                System.exit(0);
            }
        }
    }
}
