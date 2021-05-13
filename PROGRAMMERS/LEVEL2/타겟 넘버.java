import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] number = {1,1,1,1,1};
        int target = 3;
        System.out.println(solution(number,target));

    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(numbers[0]);
        queue.add(numbers[0]*(-1));

        int idx = 1;
        while (!queue.isEmpty()) {
            if(idx == numbers.length)
                break;

            int size = queue.size();

            for(int i = 0; i<size; i++) {
                int num = queue.poll();
                int new_num1 = num+numbers[idx];
                int new_num2 = num-numbers[idx];
                if(idx==numbers.length-1) {
                    if(new_num1 == target)
                        answer++;
                    if(new_num2 == target)
                        answer++;
                }
                queue.add(num + numbers[idx]);
                queue.add(num - numbers[idx]);
            }
            idx++;
        }

        return answer;
    }
}
