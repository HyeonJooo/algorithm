import java.io.*;
import java.util.*;

public class Main {

    static String[] arr;
    static int l;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        int c = sc.nextInt();

        arr = new String[c];
        for(int i = 0; i<c; i++) {
            arr[i] = sc.next();
        }
        Arrays.sort(arr);
        boolean[] visit = new boolean[c];
        dfs(arr, visit, 0, c, l);
    }

    static void dfs(String[] arr, boolean[] visit, int start, int n, int r) {
        if(r == 0) {
            String word = "";
            for(int i = 0; i<n; i++) {
                if(visit[i]) {
                    word += arr[i];
                }
            }
            check(word);
            return;
        }

        for(int i = start; i<n; i++) {
            visit[i] = true;
            dfs(arr, visit, i+1, n, r-1);
            visit[i] = false;
        }
    }

    static void check(String password) {
        int ch1 = 0, ch2 = 0;
        for(int i = 0; i<password.length(); i++) {
            if(password.charAt(i) == 'a' || password.charAt(i) == 'e' || password.charAt(i) == 'i' || password.charAt(i) == 'o' || password.charAt(i) == 'u') {
                ch1++;
            }
            else {
                ch2++;
            }
        }
        if(ch1>=1 && ch2>=2)
            System.out.println(password);
    }

}
