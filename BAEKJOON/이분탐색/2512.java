import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        Arrays.sort(arr);
        int start = 1;
        int end = arr[arr.length-1];
        int mid = 0;
        int req = 0;
        int answer = 0;

        while(start <= end) {
            req = 0;
            mid = (start + end) / 2;

            for(int i = 0; i<arr.length; i++) {
                if(arr[i] < mid)
                    req += arr[i];
                else
                    req += mid;
            }

            //상한가 줄여야 함.
            if(req > sum) {
                end = mid-1;

            }
            else {
                start = mid+1;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);
    }
}
