import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int b = 24;
        int y = 24;
        int[] ans = solution(b,y);
        for(int i = 0 ; i<ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int num = brown + yellow;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i<=num/2; i++) {
            if(num % i == 0) {
                list.add(i);
            }
        }
        list.add(num);

        int left = 0;
        int right = list.size()-1;
        for(int i = 0 ; i<list.size(); i++) {
            if(list.get(right)*2 + (list.get(left)-2)*2 == brown) {
                answer[0] = list.get(right);
                answer[1] = list.get(left);
                break;
            }
            left++;
            right--;
        }

        return answer;
    }
}
