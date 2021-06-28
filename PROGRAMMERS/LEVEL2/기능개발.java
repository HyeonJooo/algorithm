import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] p = {93,30,55};
        int[] s = {1,30,5};
        int[] ans = solution(p,s);
        for(int i = 0 ; i<ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] arr = new int[progresses.length];
        int max = -1;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i<progresses.length; i++) {
            arr[i] = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0)
                arr[i]++;
            max = Math.max(max, arr[i]);
        }

        int cnt = 1;

        for(int i = 0; i<arr.length; i++) {
            if(i==arr.length-1)
                list.add(1);
            for(int j = i+1; j<arr.length; j++) {
                if(arr[i] >= arr[j]) {
                    cnt++;
                }
                else {
                    list.add(cnt);
                    i = j-1;
                    cnt = 1;
                    break;
                }
                if(j == arr.length-1) {
                    list.add(cnt);
                    i = j;
                    break;
                }
            }
        }

        answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
