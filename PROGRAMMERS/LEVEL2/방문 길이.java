import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = "ULURRDLLU";
        System.out.println(solution(s));

    }
    public static int solution(String dirs) {
        int answer = 0;
        String[] st = dirs.split("");
        int qx = 5;
        int qy = 5;
        int nx = 0;
        int ny = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i<st.length; i++) {
            if(st[i].equals("D")) {
                if(qx<10) {
                    nx = qx+1;
                    ny = qy;
                }
            }

            else if(st[i].equals("U")) {
                if(qx>0) {
                    nx = qx-1;
                    ny = qy;
                }
            }

            else if(st[i].equals("R")) {
                if(qy<10) {
                    nx = qx;
                    ny = qy+1;
                }
            }

            else {
                if(qy>0) {
                    nx = qx;
                    ny = qy-1;
                }
            }
            if(nx==qx && ny==qy)
                continue;
            String s1 = Integer.toString(qx) + Integer.toString(qy) + Integer.toString(nx) + Integer.toString(ny);
            String s2 = Integer.toString(nx) + Integer.toString(ny) + Integer.toString(qx) + Integer.toString(qy);
            set.add(s1);
            set.add(s2);
            qx = nx;
            qy = ny;
        }
        answer = set.size()/2;
        return answer;
    }
}
