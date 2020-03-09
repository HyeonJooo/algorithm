//2016 고려대학교 프로그래밍 경시대회 5번
//백준 알고리즘 11946번 : ACM-ICPC
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	int q = sc.nextInt();
    	int[][] result = new int[n][3];
    	int[][] count = new int[n+1][m+1];
    	boolean[][] check = new boolean[n+1][m+1];
    	for(int i = 0; i<n; i++) {
    		result[i][0] = i+1;
    	}
    	for(int i = 1; i<=n; i++) {
    		for(int j = 1; j<=m; j++) {
    			check[i][j] = false;
    		}
    	}
    	
    	for(int i = 0; i<q; i++) {
    		int time = sc.nextInt();
    		int team = sc.nextInt();
    		int ques = sc.nextInt();
    		String s = sc.next();
    		
    		if(check[team][ques] == false) {
	    		count[team][ques]++;
	    		if(s.equals("AC")) {
	    			result[team-1][1]++;
	    			result[team-1][2] += time + (count[team][ques]-1)*20;
	    			check[team][ques] = true;
	    		}
    		}
    		else
    			continue;
    	}
    	Arrays.sort(result, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]>o2[1]) {
					return -1;
				}
				else if(o1[1] == o2[1]) {
					return o1[2] - o2[2];
				}
				return 1;
			}
    	});
    	
    	for(int i = 0; i<n; i++) {
    		for(int j = 0; j<3; j++) {
    			System.out.print(result[i][j] + " ");
    		}System.out.println("");
    	}
    }
}
