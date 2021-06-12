import java.io.*;
import java.util.*;

public class Main {

    static int[] table;

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        String p = br.readLine();
        table = new int[p.length()];

        makeTable(p);
        KMP(t,p);
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
        ArrayList<Integer> list = new ArrayList<>();
        int j = 0;
        for(int i = 0; i<s.length(); i++) {
            while (j>0 && s.charAt(i) != pattern.charAt(j)) {
                j = table[j-1];
            }

            if(s.charAt(i) == pattern.charAt(j)) {
                if(j == pattern.length()-1) {
                    ans++;
                    list.add(i-pattern.length()+2);
                    j = table[j];
                }
                else {
                    j++;
                }
            }
        }
        System.out.println(ans);
        for(int i = 0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
