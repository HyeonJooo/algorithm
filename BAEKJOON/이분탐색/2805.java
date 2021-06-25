import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i =0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int left = 0;
        int right = arr[arr.length-1];
        int mid = 0;
        int answer = 0;
        long cut = 0;

        while(left <= right) {
            cut = 0;
            mid = (left+right) / 2;

            for(int i = 0; i<n; i++) {
                if (arr[i] > mid) {
                    cut += arr[i] - mid;
                }
            }

            if(cut >= m) {
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
