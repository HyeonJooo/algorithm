import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = 2;
        System.out.println(solution(n));
    }

    public static long solution(int n) {
        long answer = 0;
        if(n<3)
            return n;
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i<=n; i++) {
            arr[i] = (arr[i-2] + arr[i-1]) % 1234567;
        }

        return arr[n];
    }
}
