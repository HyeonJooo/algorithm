import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long[] arr = new long[k];

        for(int i = 0; i<k; i++) {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);

        long answer = 0;
        long left = 1;
        long right = arr[arr.length-1];
        long mid = 0;
        long cnt = 0;

        while(left <= right) {
            cnt = 0;
            mid = (left+right)/2;

            for(int i = 0; i<k; i++) {
                cnt += arr[i]/mid;
            }

            if(cnt >= n) {
                answer = Math.max(answer, mid);
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }

        System.out.println(answer);
    }
}
