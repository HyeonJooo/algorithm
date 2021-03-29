import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    static boolean[] numcheck;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String numbers = "00000";
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        String[] arr = numbers.split("");
        String[] output = new String[arr.length];
        boolean[] visited = new boolean[arr.length];
        numcheck = new boolean[10000000];
        for(int i = 1; i<=numbers.length(); i++) {
            combination(arr, output, visited, 0, numbers.length(), i);
        }
        return answer;
    }

    static void combination(String[] arr, String[] output, boolean[] visited, int start, int n, int r) {
        if(start == r) {
            isDecimal(output, n);
            return;
        }

        for(int i=0; i<n; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                output[start] = arr[i];
                combination(arr, output, visited, start + 1, n, r);
                visited[i] = false;
            }
        }
    }

    static void isDecimal(String[] arr, int n) {
        String s = "";
        for(int i = 0; i<n; i++) {
            if(i==0 && arr[i].equals("0"))
                continue;

            if(arr[i] != null)
                s += arr[i];
        }
        boolean check = true;
        if(s.equals(""))
            return;
        int num = Integer.parseInt(s);
        if(num == 1 || num == 0)
            return;
        if(numcheck[num])
            return;
        numcheck[num] = true;

        for(int i = 2; i<=Math.sqrt((double) num); i++) {
            if(num % i == 0) {
                check = false;
                break;
            }
        }
        if(check)
            answer++;
    }
}
