import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[][] arr = new int[n][2];
    	for(int i = 0; i<n; i++) {
        	arr[i][0] = sc.nextInt();
        	arr[i][1] = sc.nextInt();
    	}
    	
    	Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) return Integer.compare(o1[0], o2[0]);
				return Integer.compare(o1[0], o2[0]);
			}
    	});
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	pq.add(arr[0][1]);
    	
    	for(int i = 1; i<n; i++) {
    		if(arr[i][0] >= pq.peek())
    			pq.poll();
    		pq.add(arr[i][1]);
    	}
    	System.out.println(pq.size());
    }
}
