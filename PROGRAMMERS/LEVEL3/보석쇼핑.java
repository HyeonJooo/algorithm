import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] arr = {"A", "B", "A", "A", "A", "C", "A", "B"};
        int[] ans = solution(arr);
        for(int i = 0 ; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        for(String s : gems)
            set.add(s);

        int size = set.size();
        int left = 0;
        int right = 0;
        int dis = 10000001;
        HashMap<String, Integer> map = new HashMap<>();
        int ansLeft = 0;
        int ansRight = 0;

        while(true) {
            if(right == gems.length)
                break;

            if(map.size() < size)
                map.put(gems[right], right++);

            if(map.size() == size) {
                int min = Collections.min(map.values());
                map.remove(gems[min]);
                left = min+1;
                if(dis > right-left) {
                    dis = right-left;
                    ansLeft = left;
                    ansRight = right;
                }
            }
        }
        answer[0] = ansLeft;
        answer[1] = ansRight;
        return answer;
    }
}
