import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = 2;
        String[] d = {"M~C<2", "C~M>1"};
        System.out.println(solution(n, d));

    }

    static int answer = 0;
    public static int solution(int n, String[] data) {
        // 1. permutation으로 8명 뽑는 경우의 수 구하기
        // 2. 뽑은 경우의 수가 조건을 모두 만족하는지 확인
        String[] friends = {"A","C","F","J","M","N","R","T"};
        answer = 0;
        permutation(data, friends, 0, 8, 8);
        return answer;
    }

    static void permutation(String[] data, String[] arr, int depth, int n, int r) {
        if(depth == r) {
            count(arr, data);
            return;
        }

        for(int i = depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(data, arr, depth+1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static void count(String[] arr, String[] data) {
        for(int i = 0; i<data.length; i++) {
            String want = data[i];
            int idx1 = 0, idx2 = 0;
            String s1 = Character.toString(want.charAt(0));
            String s2 = Character.toString(want.charAt(2));
            for(int j = 0; j<arr.length; j++) {
                if(arr[j].equals(s1))
                    idx1 = j;
                if(arr[j].equals(s2))
                    idx2 = j;
            }
            int len = Math.abs(idx1-idx2)-1;
            if(want.charAt(3) == '=') {
                if(len == Integer.parseInt(Character.toString(want.charAt(4))))
                    continue;
                else
                    return;
            }

            else if(want.charAt(3) == '<') {
                if(len < Integer.parseInt(Character.toString(want.charAt(4))))
                    continue;
                else
                    return;
            }

            else {
                if(len > Integer.parseInt(Character.toString(want.charAt(4))))
                    continue;
                else
                    return;
            }
        }
        answer++;
    }
}
