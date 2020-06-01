//백준 알고리즘 2623번 : 음악 프로그램
import java.io.*;
import java.util.*;

public class Main {
   static int start,end;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();//인접리스트
        int[] degree = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i<=n+1; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i<m; i++) {
        	StringTokenizer st1 = new StringTokenizer(br.readLine());
        	int num = Integer.parseInt(st1.nextToken());
        	int[] arr = new int[num];
        	for(int j = 0; j<num; j++) {
        		arr[j] = Integer.parseInt(st1.nextToken());
        	}
        	for(int j = 0; j<num-1; j++) {
        		for(int k = j+1; k<num; k++) {
        			int a = arr[j];
        			int b = arr[k];
                	list.get(a).add(b); //a뒤에 서야하는 사람
                	degree[b]++;//b앞에 있는 사람 수        		        			
        		}
        	}
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
        		bw.write(x + "\n");
        		
        		for(int j = 0; j<list.get(x).size(); j++) {//큐에서 뺀 x의 인접리스트
        			degree[list.get(x).get(j)]--;//x가 빠졌으므로 x뒤에 있던애들 degree 1씩감소
        			
        			if(degree[list.get(x).get(j)]==0) {
        				queue.add(list.get(x).get(j));
        				degree[list.get(x).get(j)] = -1;
        			}
        		}
        	}
        	else {
        		System.out.print(0);
        		System.exit(0);
        	}	
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
