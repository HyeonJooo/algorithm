import java.io.*;
import java.util.*;
public class Main {
    static boolean[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        arr = new boolean[10001];
        for(int i = 2; i<arr.length; i++){
            arr[i] = true;
        }

        //true==소수
        for(int i = 2; i*i<=10000; i++) {
            for(int j = i*i; j<=10000; j+=i) {
                arr[j] = false;
            }
        }

        for(int t = 0; t<tc; t++) {
            visit = new boolean[10001];
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ans = bfs(a,b);
            System.out.println(ans);
        }

    }

    static int bfs(int a, int b) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);

        while(!queue.isEmpty()) {
            int size = queue.size();
            int[] splitNum = new int[4];

            for(int i = 0 ; i<size; i++) {
                int q = queue.peek();
                queue.poll();
                if(q == b)
                    return cnt;

                for(int j = 0; j<4; j++) {
                    splitNum = parseNum(q);
                    for(int k = 0; k<=9; k++) {
                        if(j==0 && k==0)
                            continue;

                        splitNum[j] = k;
                        int currentNum = toInt(splitNum);

                        if(visit[currentNum]) //이미 방문했으면 건너뜀
                            continue;
                        if(!check(currentNum)) //소수아니면 건너뜀
                            continue;

                        visit[currentNum] = true;
                        queue.offer(currentNum);
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }

    static boolean check(int num) {
        if(arr[num])
            return true;
        return false;
    }

    static int[] parseNum(int n) {
        int[] arr = new int[4];
        int i = 3;
        while(n != 0) {
            arr[i] = n%10;
            n /= 10;
            i--;
        }
        return arr;
    }

    static int toInt(int[] arr) {
        int num = 0;
        int a = 1000;
        for(int i = 0; i<4; i++) {
            num += arr[i]*a;
            a/=10;
        }
        return num;
    }
}
