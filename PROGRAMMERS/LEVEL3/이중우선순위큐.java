import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] op = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
        int[] ans = solution(op);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<operations.length; i++) {
            if(operations[i].equals("D 1")) {
                if(!list.isEmpty()) {
                    Collections.sort(list);
                    list.remove(list.size()-1);
                }
            }

            else if(operations[i].equals("D -1")) {
                if(!list.isEmpty()) {
                    Collections.sort(list);
                    list.remove(0);
                }
            }

            else {
                list.add(Integer.parseInt(operations[i].split(" ")[1]));
            }
        }

        if(list.size() >= 2) {
            Collections.sort(list);
            answer[0] = list.get(list.size()-1);
            answer[1] = list.get(0);
        }
        else {
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }
}
