//백준 알고리즘 9576번 : 책 나눠주기
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0 ; i<t; i++) {
        	int count = 0;
        	int n = sc.nextInt();
        	int m = sc.nextInt();
        	int[][] arr = new int[m][2];
        	
        	for(int j = 0; j<m; j++) {
        		arr[j][0] = sc.nextInt();
        		arr[j][1] = sc.nextInt();
        	}
        	boolean[] check = new boolean[n+1];
        	
        	Arrays.sort(arr, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
					return Integer.compare(o1[1], o2[1]);
				}
        	});
        	
        	for(int a = 0; a<m; a++) {
        		int num1 = arr[a][0];
        		int num2 = arr[a][1];
        		
        		for(int b = num1; b<=num2; b++) {
        			if(check[b] == false) {
        				check[b] = true;
        				count++;
        				break;
        			}
        		}
        	}
        	System.out.println(count);
        }
    }
}
