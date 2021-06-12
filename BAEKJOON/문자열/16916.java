import java.io.*;
import java.util.*;

public class Main {

    static int[] table;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        table = new int[p.length()];

        makeTable(p);
        KMP(s,p);
        System.out.println(0);
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
        int j = 0;
        for(int i = 0; i<s.length(); i++) {
            while (j>0 && s.charAt(i) != pattern.charAt(j)) {
                j = table[j-1];
            }

            if(s.charAt(i) == pattern.charAt(j)) {
                if(j == pattern.length()-1) {
                    System.out.println(1);
                    System.exit(0);
                }
                else {
                    j++;
                }
            }
        }
    }
}
