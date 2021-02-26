import java.io.*;
import java.util.*;

class Node {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {
    static int v;

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt(); //정점의 개수
        List<Node>[] list = new ArrayList[v+1];
        int[] dist = new int[v+1];

        for(int i = 1; i<=v; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<v; i++) {
            int num = sc.nextInt(); //정점 번호
            while(true) {
                int num1 = sc.nextInt(); //정점 번호
                if(num1 == -1)
                    break;
                int num2 = sc.nextInt(); //그 정점까지의 거리
                list[num].add(new Node(num1, num2));
            }
        }
        dist = bfs(list, 1); //start에서 가장 먼 노드찾기
        int max = 1;
        for(int i = 2; i<=v; i++) {
            if(dist[max] < dist[i])
                max = i;
        }
        dist = bfs(list, max); //가장 먼 노드에서 다시 가장 먼노드 찾기
        Arrays.sort(dist);
        System.out.println(dist[v]);
    }

    public static int[] bfs(List<Node>[] list, int start) {
        boolean[] visit = new boolean[v+1];
        int[] dist = new int[v+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while(!queue.isEmpty()) {
            int num = queue.poll();
            for(Node n : list[num]) {
                int to = n.to;
                int cost = n.cost;

                if(!visit[to]) {
                    visit[to] = true;
                    dist[to] = dist[num] + cost;
                    queue.add(to);
                }
            }
        }
        return dist;
    }
}
