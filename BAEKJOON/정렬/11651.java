//백준 알고리즘 11651번 : 좌표 정렬하기2
import java.io.*;
import java.util.*;
public class Main {
	
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
   	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   	   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   	   
   	   int n = Integer.parseInt(br.readLine());
   	   int[][] arr = new int[n][2];
   	   for(int i = 0; i<n; i++) {
   		   String[] s = br.readLine().split(" ");
   		   for(int j = 0; j<2; j++) {
   			   arr[i][j] = Integer.parseInt(s[j]);
   		   }
   	   }
   	   Arrays.sort(arr, new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[1]==o2[1]) return Integer.compare(o1[0], o2[0]);
			return Integer.compare(o1[1], o2[1]);
		} 
   	   });   		   
   	   for(int i = 0; i<n; i++) {
   		   for(int j = 0; j<2; j++) {
   			   System.out.print(arr[i][j]+" ");
   		   }System.out.println("");
   	   }

    }
}
