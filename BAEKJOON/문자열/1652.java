import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] arr = new String[n][n];
        for(int i = 0; i<n; i++) {
            String s = sc.next();
            arr[i] = s.split("");
        }
        int cnt = 0;
        int ans = 0;
        int ans2 = 0;
        boolean check = false;
        for(int i = 0; i<n; i++) {
            cnt = 0;
            check = false;
            for(int j = 0 ; j<n; j++) {
                if(arr[i][j].equals(".")) {
                    if(check) {
                        cnt++;
                        continue;
                    }
                    cnt++;
                    check = true;
                    continue;
                }
                else {
                    if(cnt>=2)
                        ans++;
                    cnt = 0;
                    check = false;
                }
            }
            if(cnt >= 2 && check)
                ans++;
        }
        check = false;

        for(int i = 0 ; i<n; i++) {
            cnt = 0;
            check = false;
            for(int j = 0 ; j<n; j++) {
                if(arr[j][i].equals(".")) {
                    if(check) {
                        cnt++;
                        continue;
                    }
                    cnt++;
                    check = true;
                    continue;
                }
                else {
                    if(cnt>=2)
                        ans2++;
                    cnt = 0;
                    check = false;
                }
            }
            if(cnt >=2 && check)
                ans2++;
        }
        System.out.println(ans + " " + ans2);
    }
}
