//백준 알고리즘 1781번 : 컵라면
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for(int i = 0 ; i<n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return Integer.compare(o2[1], o1[1]);
				return Integer.compare(o1[0], o2[0]);
			}
		});
		Queue<Integer> queue = new PriorityQueue<>();
		for(int i = 0 ; i<n; i++) {
			queue.add(arr[i][1]);
			while(queue.size() > arr[i][0])
				queue.poll();
			
		}
		int count = 0;
		while(!queue.isEmpty()) {
			count += queue.poll();
		}
		
		System.out.println(count);
	}
}
