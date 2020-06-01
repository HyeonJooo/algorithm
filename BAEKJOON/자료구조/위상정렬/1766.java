//백준 알고리즘 1766번 : 문제집
import java.io.*;
import java.util.*;

public class Main {
   static int start,end;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();//인접리스트
        int[] degree = new int[n+1];
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i = 1 ; i<=n+1; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i<m; i++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	list.get(a).add(b); //a뒤에 서야하는 사람
        	degree[b]++;//b앞에 있는 사람 수
        }
        
        for(int i = 1; i<=n; i++) {
        	if(degree[i] == 0) {//degree가 0이면 큐에 넣고
        		queue.add(i);
        		degree[i] = -1;//넣은애는 -1로 표시
        	}
        }
        
        for(int i = 0; i<n; i++) {
        	if(!queue.isEmpty()) {
        		int x = queue.poll();
        		System.out.print(x + " ");
        		
        		for(int j = 0; j<list.get(x).size(); j++) {//큐에서 뺀 x의 인접리스트
        			degree[list.get(x).get(j)]--;//x가 빠졌으므로 x뒤에 있던애들 degree 1씩감소
        			
        			if(degree[list.get(x).get(j)]==0) {
        				queue.add(list.get(x).get(j));
        				degree[list.get(x).get(j)] = -1;
        			}
        		}
        	}
        	else
        		break;
        }
    }
}
