import java.io.*;
import java.util.*;

public class Main {

    static String[][] arr;
    static int n;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new String[n][n];
        for(int i = 0; i<n; i++) {
            String s = sc.next();
            arr[i] = s.split("");
        }

        for(int i = 0 ; i<n; i++) {
            for(int j = 0; j<n-1; j++) {
                change1(i,j);
                check1(i);
                check2(j);
                check3(j);
                change1(i,j);
            }
        }

        for(int i = 0 ; i<n-1; i++) {
            for(int j = 0 ; j<n; j++) {
                change2(i,j);
                check1(i);
                check1(i+1);
                check3(j);
                change2(i,j);
            }
        }
        System.out.println(answer);
    }

    static void change1(int i, int j) {
        String temp = arr[i][j];
        arr[i][j] = arr[i][j+1];
        arr[i][j+1] = temp;
    }

    static void change2(int i, int j) {
        String temp = arr[i][j];
        arr[i][j] = arr[i+1][j];
        arr[i+1][j] = temp;
    }

    //가로검사
    static void check1(int a) {
        boolean ch = false;
        int cnt = 1;
        int max = -1;
        for(int i = 0; i<n-1; i++) {
            if(arr[a][i].equals(arr[a][i+1])) {
                cnt++;
                ch = false;
            }

            else {
                ch = true;
                max = Math.max(max, cnt);
                cnt = 1;
            }
        }
        max = Math.max(max, cnt);
        answer = Math.max(max, answer);
    }

    //세로검사1
    static void check2(int a) {
        boolean ch = false;
        int cnt = 1;
        int max = -1;
        for(int i = 0; i<n-1; i++) {
            if(arr[i][a+1].equals(arr[i+1][a+1])){
                cnt++;
                ch = false;
            }
            else {
                ch = true;
                max = Math.max(max, cnt);
                cnt = 1;
            }
        }
        max = Math.max(max, cnt);
        answer = Math.max(max, answer);
    }

    //세로검사2
    static void check3(int a) {
        boolean ch = false;
        int cnt = 1;
        int max = -1;
        for(int i = 0; i<n-1; i++) {
            if(arr[i][a].equals(arr[i+1][a])) {
                cnt++;
                ch = false;
            }
            else {
                ch = true;
                max = Math.max(max, cnt);
                cnt = 1;
            }
        }
        max = Math.max(max, cnt);
        answer = Math.max(max, answer);
    }
}
