import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String p = "02:03:55";
        String a = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        System.out.println(solution(p,a,logs));
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        if(play_time.equals(adv_time))
            return "00:00:00";

        int allPlayTime = toSec(play_time);
        int allAdTime = toSec(adv_time);
        int[] plays = new int[allPlayTime+1];

        for(int i = 0; i< logs.length; i++) {
            int start = toSec(logs[i].substring(0, 8));
            int end = toSec(logs[i].substring(9, 17));

            for(int j = start; j<end; j++) {
                plays[j]++;
            }
        }

        long sum = 0;
        int idx = 0;

        for(int i = 0; i<allAdTime; i++) {
            sum += plays[i];
        }
        long max = sum;

        for(int i = allAdTime; i<plays.length; i++) {
            sum += plays[i] - plays[i-allAdTime];
            if(sum > max) {
                max = sum;
                idx = i - allAdTime + 1;
            }
        }
        return String.format("%02d:%02d:%02d", idx/3600, idx/60%60, idx%60);
    }
    static int toSec(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0])*3600 +
                Integer.parseInt(times[1])*60 +
                Integer.parseInt(times[2]);
    }
}
