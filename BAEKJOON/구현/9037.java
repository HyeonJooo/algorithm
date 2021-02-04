import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0 ; i<t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int j = 0 ; j<n; j++) {
                int num = sc.nextInt();
                if(num%2 != 0)
                    num += 1; //홀수이면 짝수로 보충을 먼저 해주고 시작
                arr[j] = num;
            }
            if(check(arr)) {
                System.out.println(0);
                continue;
            }

            int count = 0; //순환횟수
            int[] half = new int[n];
            while(true) {
                if(check(arr))
                    break;

                for(int a = 0; a<arr.length; a++) {
                    arr[a] /= 2;
                    half[a] = arr[a];
                }

                for(int a = 1; a<arr.length; a++) {
                    arr[a] += half[a-1];
                    if(arr[a]%2 != 0)
                        arr[a] += 1;
                }
                arr[0] += half[n-1];
                if(arr[0]%2 != 0)
                    arr[0] += 1;

                count++;
            }
            System.out.println(count);
        }
    }

    static boolean check(int[] arr) {
        boolean same = true;
        for(int i = 0; i<arr.length-1; i++) {
            if(arr[i] != arr[i+1]) {
                same = false;
                break;
            }
        }
        return same;
    }
}
