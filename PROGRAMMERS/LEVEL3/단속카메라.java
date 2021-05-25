import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[][] r = {{-20,15},{-14,-5},{-18,-13},{-5,-3}};
        System.out.println(solution(r));
    }

    public static int solution(int[][] routes) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i<routes.length; i++) {
            list.add(routes[i]);
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        while (list.size() != 0) {
            int time = list.get(0)[1];
            for(int i = 0 ; i< list.size(); i++) {
                if(list.get(i)[0] <= time) {
                    list.remove(i);
                    i--;
                }
            }
            answer++;
        }

        return answer;
    }
}
