import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int num = 40;
        System.out.println(solution(n,num));
    }

    static int answer;
    public static int solution(int N, int number) {
        answer = Integer.MAX_VALUE;
        dfs(N,number,0,0);
        if(answer > 8)
            return -1;

        return answer;
    }

    static void dfs(int n, int number, int idx, int sum) {
        if(idx > 8)
            return;
        if(sum == number) {
            answer = Math.min(answer, idx);
        }

        int tmp = 0;

        for(int i = 1; i<=8; i++) {
            tmp = tmp*10 + n;
            dfs(n, number, idx+i, sum+tmp);
            dfs(n, number, idx+i, sum-tmp);
            dfs(n, number, idx+i, sum/tmp);
            dfs(n, number, idx+i, sum*tmp);

        }
    }
}
