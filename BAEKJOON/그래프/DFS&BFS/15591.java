import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visit;
    static int n;
    static ArrayList<int[]>[] list;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int q = sc.nextInt();
        list = new ArrayList[n+1];
        for(int i = 1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i<n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list[a].add(new int[]{b,c});
            list[b].add(new int[]{a,c});
        }

        for(int i = 0; i<q; i++) {
            int k = sc.nextInt();
            int v = sc.nextInt();
            bfs(k,v);
        }
    }

    static void bfs(int k, int v) {
        visit = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visit[v] = true;
        int ans = 0;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int[] a : list[cur]) {
                if(!visit[a[0]] && a[1] >= k) {
                    queue.add(a[0]);
                    visit[a[0]] = true;
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
