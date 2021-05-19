import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[][] arr = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "a"},
                {"abc","b"},{"wfaf","c"}};
        System.out.println(solution(arr));
    }


    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> count = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (count.containsKey(clothes[i][1]))
                count.put(clothes[i][1], count.get(clothes[i][1]) + 1);
            else
                count.put(clothes[i][1], 1);
        }

        Iterator<Integer> it = count.values().iterator();
        while(it.hasNext()) {
            answer *= it.next().intValue() + 1;
        }

        return answer-1;
    }
}
