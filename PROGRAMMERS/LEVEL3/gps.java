//2017 카카오코드 gps - 테케통과, 제출오답
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = 8;
        int m = 11;
        int[][] list = {{1,2},{1,3},{2,3},{2,4},{3,4},{3,5},{4,6},{5,6},{5,7},{6,7},{2,8}};
        int k = 6;
        int[] gps = {1,2,8,8,5,7};
        System.out.println(solution(n,m,list,k,gps));
    }

    static List<List<Integer>> list;
    public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;
        list = new ArrayList<>();
        for(int i = 1; i<=n+1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i<edge_list.length; i++) {
            list.get(edge_list[i][0]).add(edge_list[i][1]);
            list.get(edge_list[i][1]).add(edge_list[i][0]);
        }

        int ans = 0;
        for(int i = 0; i< gps_log.length-1; i++) {
            if(gps_log[i] != gps_log[i+1] && !list.get(gps_log[i]).contains(gps_log[i+1])) {
                ans = bfs(gps_log,i+1);
                if(ans == -1)
                    return -1;
                answer += ans;
            }
        }
        return answer;
    }

    static int bfs(int[] gps_log, int idx) {
        Queue<Integer> queue = new LinkedList<>();
        for(Integer i : list.get(gps_log[idx])) {
            queue.add(i);
        }

        int time = 1;

        while (!queue.isEmpty()) {
            if(idx < 0)
                break;
            int size = queue.size();

            for(int i = 0; i<size; i++) {
                int pos = queue.poll();
                if(list.get(pos).contains(gps_log[idx-1])) {
                    return time;
                }

                for(Integer p : list.get(pos)) {
                    queue.add(p);
                }
            }
            time++;
            idx--;
        }
        return -1;
    }



}
