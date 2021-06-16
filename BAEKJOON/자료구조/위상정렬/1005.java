import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); //테스트케이스 개수

        for(int t = 0; t<tc; t++) {
            int n = sc.nextInt(); //건물 개수
            int k = sc.nextInt(); //건설순서규칙 개수
            List<List<Integer>> list = new ArrayList<>();
            int[] time = new int[n+1]; //건물당 건설에 걸리는 시간

            for(int i = 0 ; i<n; i++) {
                time[i+1] = sc.nextInt();
            }

            for(int i = 1; i<=n+1; i++) {
                list.add(new ArrayList<>());
            }
            int[] degree = new int[n+1];
            Queue<Integer> queue = new LinkedList<>();

            for(int i = 0; i<k; i++) {
                int x = sc.nextInt(); // x먼저
                int y = sc.nextInt(); // y가 나중에
                list.get(x).add(y);
                degree[y]++; //y보다 먼저 지어야 하는 건물 개수
            }

            int w = sc.nextInt(); //승리하기 위해 건설해야하는 건물번호
            int[] result = new int[n+1];

            for(int i = 1; i<=n; i++) {
                result[i] = time[i];
                if(degree[i] == 0) {
                    degree[i] = -1;
                    queue.add(i);
                }
            }

            while(!queue.isEmpty()) {
                int x = queue.poll();

                for(int j = 0 ; j<list.get(x).size(); j++) {
                    degree[list.get(x).get(j)]--;
                    result[list.get(x).get(j)] = Math.max(result[list.get(x).get(j)], result[x] + time[list.get(x).get(j)]);

                    if(degree[list.get(x).get(j)] == 0) {
                        queue.add(list.get(x).get(j));
                    }
                }
            }
            System.out.println(result[w]);
        }
    }
}
