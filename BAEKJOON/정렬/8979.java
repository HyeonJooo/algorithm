import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] medal = new int[n][4];

        for(int i = 0 ; i<n; i++) {
            medal[i][0] = sc.nextInt();
            medal[i][1] = sc.nextInt();
            medal[i][2] = sc.nextInt();
            medal[i][3] = sc.nextInt();
        }
        if(n==1) {
            System.out.println(1);
            System.exit(0);
        }

        Arrays.sort(medal,(a,b)->{
            if(a[1]!=b[1]) return a[1]-b[1];
            else if(a[2]!=b[2])return a[2]-b[2];
            else return a[3]-b[3];
        });


        int cnt = 0;
        int idx = 0;

        for(int i = 0 ; i<n; i++) {
            if(medal[i][0] == k) {
                idx = i;
                break;
            }
        }

        for(int i = idx; i<n-1; i++) {
            if(medal[i][1]==medal[i+1][1] && medal[i][2]==medal[i+1][2] &&medal[i][3]==medal[i+1][3]) {
                cnt++;
            }
            else
                break;
        }
        System.out.println(n-idx-cnt);
    }
}
