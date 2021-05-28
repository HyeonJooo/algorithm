import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] p = {1,1,9,1,1,1};
        int l = 0;
        System.out.println(solution(p,l));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i<priorities.length; i++) {
            queue.add(i);
            map.put(i, priorities[i]);
        }

        while(true) {
            int idx = queue.peek();
            boolean ch = false;
            int idxPr = map.get(idx);

            Iterator<Integer> keys = map.keySet().iterator();
            while(keys.hasNext()) {
                if(map.get(keys.next()) > idxPr) {
                    ch = true;
                    break;
                }
            }

            if(ch) {
                queue.add(idx);
                queue.poll();
            }
            else {
                if(idx == location) {
                    break;
                }
                answer++;
                queue.poll();
                map.remove(idx);
            }
        }

        return answer+1;
    }
}
