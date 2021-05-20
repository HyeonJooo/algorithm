import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] g = {45, 4, 35, 20, 3, 9};
        int[] p = {20, 9, 3, 45, 4, 35};
        int[] ans = solution(g,p);
        for(int i = 0; i<ans.length; i++)
            System.out.println(ans[i]);

    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0;
        int cnt = 0;
        for(int i = 0; i< lottos.length; i++) {
            if(lottos[i] == 0)
                zero++;
            else {
                for(int j = 0; j< win_nums.length; j++) {
                    if(lottos[i] == win_nums[j]) {
                        cnt++;
                        break;
                    }
                }
            }
        }

        if(zero != 0) {
            answer[0] = 7-cnt-zero;
            if(cnt<2)
                answer[1] = 6;
            else
                answer[1] = 7-cnt;
        }
        else {
            if(cnt<2) {
                answer[0] = 6;
                answer[1] = 6;
            }
            else {
                answer[0] = 7-cnt;
                answer[1] = 7-cnt;
            }
        }
        return answer;
    }
}
