import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] lines = {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
        System.out.println(solution(lines));
    }

    public static int solution(String[] lines) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();
        if(lines.length == 1)
            return 1;

        for(int i = 0; i< lines.length; i++) {
            String log = lines[i];
            log = log.replaceAll("2016-09-15 ", "");
            log = log.replaceAll("s", "");
            String[] st = log.split(" ");
            String[] endTime = st[0].split(":");
            
            int[] time = new int[2];
            time[1] = Integer.parseInt(endTime[0])*3600000 +
                    Integer.parseInt(endTime[1])*60000 +
                    Integer.parseInt(endTime[2].split("\\.")[0])*1000 +
                    Integer.parseInt(endTime[2].split("\\.")[1]);
            time[0] = time[1] - (int)( Double.parseDouble(st[1]) * 1000) + 1;
            list.add(time);
        }

        for(int i = 0; i<list.size(); i++) {
            int start1 = list.get(i)[0];
            int end1 = start1 + 1000;
            int cnt1 = 0;

            for(int j = 0 ; j<list.size(); j++) {
                if(list.get(j)[0] >= start1 && list.get(j)[0] < end1)
                    cnt1++;
                else if(list.get(j)[0] <= start1 && list.get(j)[1] >= end1)
                    cnt1++;
                else if(list.get(j)[1] >= start1 && list.get(j)[1] < end1)
                    cnt1++;
            }

            int start2 = list.get(i)[1];
            int end2 = start2 + 1000;
            int cnt2 = 0;

            for(int j = 0; j<list.size(); j++) {
                if(list.get(j)[0] >= start2 && list.get(j)[0] < end2)
                    cnt2++;
                else if(list.get(j)[0] <= start2 && list.get(j)[1] >= end2)
                    cnt2++;
                else if(list.get(j)[1] >= start2 && list.get(j)[1] < end2)
                    cnt2++;
            }
            answer = Math.max(answer, Math.max(cnt1,cnt2));
        }

        return answer;
    }
}
