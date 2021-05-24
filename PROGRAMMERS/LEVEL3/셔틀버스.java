import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = 1;
        int t = 1;
        int m = 5;
        String[] time = {"08:00", "08:01", "08:02", "08:03"};
        System.out.println(solution(n,t,m,time));
    }

    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "0";
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i<timetable.length; i++) {
            int crew_hour = Integer.parseInt(timetable[i].split(":")[0]);
            int crew_min = Integer.parseInt(timetable[i].split(":")[1]);
            queue.add(crew_hour*60 + crew_min);
        }

        int cur = 9*60;
        int ans = 0;
        for(int i = 0 ; i<n; i++) {
            int people = 0;

            for(int j = 0; j<m; j++) {
                if(!queue.isEmpty()) {
                    int crew = queue.peek();
                    if(cur >= crew) {
                        ans = queue.poll();
                        people++;
                    }
                }

                //마지막버스이고, 자리가 꽉찬 경우
                if(i == n-1 && people == m) {
                    ans--;
                }
                //마지막 버스이고 자리가 남는 경우
                else if(i == n-1 && people < m) {
                    ans = cur;
                }
            }
            cur += t;
        }
        int hour = ans/60;
        int min = ans%60;
        if(hour<10)
            answer += hour;
        else
            answer = Integer.toString(hour);
        answer += ":";
        if(min <10)
            answer += "0";
        answer += min;

        return answer;
    }
}
