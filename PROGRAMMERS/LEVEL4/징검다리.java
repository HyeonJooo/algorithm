import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int dis = 25;
        int[] rocks = {2,14,11,21,17};
        int n = 2;
        System.out.println(solution(dis,rocks,n));
    }

    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);

        int start = 1;
        int end = distance;
        int mid = 0;
        int cnt = 0;
        int last = 0;

        while(start <= end) {
            mid = (start + end) / 2;
            cnt = 0;
            last = 0;

            for (int i = 0; i < rocks.length; i++) {
                if (mid > rocks[i] - last) {
                    cnt++;
                } else
                    last = rocks[i];
            }
            if (mid > distance - last)
                cnt++;

            if (cnt > n)
                end = mid - 1;
            else {
                start = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        return answer;
    }
}
