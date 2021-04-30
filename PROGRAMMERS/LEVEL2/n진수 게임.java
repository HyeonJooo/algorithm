import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 2;
        System.out.println(solution(n,t,m,p));
    }

    public static String word = "0";
    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        conversion(n, m, p ,t);
        String[] st = word.split("");
        int cnt = 0;
        for(int i = p-1; i<st.length; i++) {
            answer += st[i];
            i += m-1;
            cnt++;
            if(cnt == t)
                break;
        }
        return answer;
    }

    public static void conversion(int n,int  m, int p, int t) {
        StringBuilder sb = new StringBuilder();
        int current = 1;
        int num = 1;

        while(word.length() <= m*t) {
            while(current > 0) {
                if(current % n < 10) {
                    sb.append(current % n);
                }
                else {
                    sb.append((char)(current % n - 10 + 'A'));
                }
                current /= n;
            }
            word += sb.reverse();
            num++;
            current = num;
            sb = new StringBuilder();
        }
    }
}
