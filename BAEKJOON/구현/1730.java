import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static String[][] arr;
    static int x = 0;
    static int y = 0;
    static int qx,qy;

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String move = br.readLine();
        arr = new String[n][n];
        for(int i = 0 ; i<n; i++) {
            for(int j = 0; j<n; j++) {
                arr[i][j] = ".";
            }
        }

        String[] st;
        st = move.split("");

        for(int i = 0; i<st.length; i++) {
            String s = st[i];
            if(isPossible(x,y,s)) {
                draw(x,y,qx,qy,s);
                x = qx;
                y = qy;
            }
        }

        for(int i = 0 ; i<n; i++) {
            for(int j = 0 ; j<n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    static boolean isPossible(int x, int y, String dir) {
        qx = x;
        qy = y;

        if(dir.equals("D"))
            qx++;

        else if(dir.equals("U"))
            qx--;

        else if(dir.equals("L"))
            qy--;

        else
            qy++;

        if(qx < 0 || qy < 0 || qx >= n || qy >= n)
            return false;

        return true;
    }

    static void draw(int x, int y, int qx, int qy, String dir) {
        if(dir.equals("D") || dir.equals("U")) {
            if(arr[qx][qy].equals(".") || arr[qx][qy].equals("|"))
                arr[qx][qy] = "|";
            else
                arr[qx][qy] = "+";

            if(arr[x][y].equals("-") || arr[x][y].equals("+"))
                arr[x][y] = "+";
            else
                arr[x][y] = "|";
        }

        if(dir.equals("R") || dir.equals("L")) {
            if(arr[qx][qy].equals(".") || arr[qx][qy].equals("-"))
                arr[qx][qy] = "-";
            else
                arr[qx][qy] = "+";

            if(arr[x][y].equals("|") || arr[x][y].equals("+"))
                arr[x][y] = "+";
            else
                arr[x][y] = "-";
        }
    }
}
