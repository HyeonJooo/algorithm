import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visit;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        list = new ArrayList<>();
        visit = new boolean[n];

        for(int i = 0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i = 0; i<n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(i, 0);
                visit = new boolean[n];

            }
        }
        System.out.println(0);
    }

    static void dfs(int num, int cnt) {
        if(cnt == 4) {
            System.out.println(1);
            System.exit(0);
        }

        for(int i = 0; i<list.get(num).size(); i++) {
            if(!visit[list.get(num).get(i)]) {
                visit[list.get(num).get(i)] = true;
                dfs(list.get(num).get(i), cnt+1);
                visit[list.get(num).get(i)] = false;
            }
        }
    }
}
