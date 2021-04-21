import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visit;
    static int answer = 0;
    static int deleteNode;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new ArrayList[n];
        for(int i = 0 ; i<n; i++) {
            tree[i] = new ArrayList<>();
        }
        visit = new boolean[n];
        int root = 0;
        for(int i = 0 ; i<n; i++) {
            int parent = sc.nextInt();
            if(parent != -1) {
                tree[i].add(parent);
                tree[parent].add(i);
            }
            else
                root = i;
        }

        deleteNode = sc.nextInt();
        if(deleteNode == root) {
            System.out.println(0);
            System.exit(0);
        }
        dfs(root);
        System.out.println(answer);
    }

    static void dfs(int node) {
        visit[node] = true;
        int child = 0;

        for(int i = 0 ; i<tree[node].size(); i++) {
            int adj = tree[node].get(i);
            if(!visit[adj] && adj != deleteNode) {
                child++;
                dfs(adj);
            }
        }

        if(child == 0)
            answer++;
    }
}
