import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = 6;
        int[] times = {7,10};
        System.out.println(solution(n,times));
    }

    public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long start = 1;
        long end = (long) times[times.length-1] * n;
        long mid = 0;
        long sum = 0;

        while(start <= end) {
            mid = (start + end) / 2;
            sum = 0;

            for(int i = 0; i< times.length; i++) {
                sum += mid / times[i];
            }

            //시간부족. 더 늘려야 함
            if(sum < n) {
                start = mid+1;
            }

            //시간 남음. 줄여야 함.
            else {
                end = mid-1;
                answer = Math.min(answer, mid);
            }
        }
        return answer;
    }
}
