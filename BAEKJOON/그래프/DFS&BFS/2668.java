import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> list = new ArrayList<>();
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n+1];
        visit = new boolean[n+1];

        for(int i = 1; i<=n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i<=n; i++) {
            visit[i] = true;
            dfs(i,i);
            visit[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i = 0; i< list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static void dfs(int start, int end) {
        if(!visit[arr[start]]) {
            visit[arr[start]] = true;
            dfs(arr[start], end);
            visit[arr[start]] = false;
        }

        if(arr[start] == end)
            list.add(end);
    }
}
