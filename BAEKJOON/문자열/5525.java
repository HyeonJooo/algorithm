import java.io.*;
import java.util.*;

public class Main {

    static int[] table;

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("I");
        for(int i = 0 ; i<n; i++) {
            sb.append("OI");
        }
        String p = sb.toString();
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        table = new int[p.length()];

        makeTable(p);
        KMP(s,p);
    }

    static void makeTable(String pattern) {
        int j = 0;
        for(int i = 1; i<pattern.length(); i++) {
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j-1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)) {
                table[i] = ++j;
            }
        }
    }

    static void KMP(String s, String pattern) {
        int ans = 0;
        int j = 0;
        for(int i = 0; i<s.length(); i++) {
            while (j>0 && s.charAt(i) != pattern.charAt(j)) {
                j = table[j-1];
            }

            if(s.charAt(i) == pattern.charAt(j)) {
                if(j == pattern.length()-1) {
                    ans++;
                    j = table[j];
                }
                else {
                    j++;
                }
            }
        }
        System.out.println(ans);
    }
}
