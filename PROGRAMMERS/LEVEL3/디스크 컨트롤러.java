import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[][] j = {{0,10},{4,10},{5,11},{15,2}};
        System.out.println(solution(j));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();

        for(int i = 0; i<jobs.length; i++) {
            list.add(jobs[i]);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int finish = 0;
        int sum = 0;

        while (!list.isEmpty()) {
            if(finish < list.get(0)[0]) {
                finish++;
                continue;
            }

            while(true) {
                if (!list.isEmpty() && finish >= list.get(0)[0]) {
                    pq.add(list.get(0));
                    list.remove(0);
                }
                else
                    break;
            }
            
            while(!pq.isEmpty()) {
                finish += pq.peek()[1];
                sum += finish - pq.peek()[0];
                pq.poll();

                while(true) {
                    if (!list.isEmpty() && finish >= list.get(0)[0]) {
                        pq.add(list.get(0));
                        list.remove(0);
                    } else
                        break;
                }
            }
        }
        answer = sum / jobs.length;
        return answer;
    }
}
