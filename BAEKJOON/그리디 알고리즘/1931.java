//백준 알고리즘 1931번 : 회의실배정
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
    	
    	Arrays.sort(arr, new Comparator<int[]>() { //먼저 끝나는 시간 순으로 정렬

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) return Integer.compare(o1[0], o2[0]);
				return Integer.compare(o1[1], o2[1]);
			}
    	});
    	
    	int count = 0;
    	int end = -1;
    	
    	for(int i = 0; i<n; i++) {
    		if(arr[i][0] >= end) {
    			end = arr[i][1];
    			count++;
    		}
    	}
    	System.out.println(count);	
    }
}
