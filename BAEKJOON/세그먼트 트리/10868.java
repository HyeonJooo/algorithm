import java.io.*;
import java.util.*;


public class Main {
   static int[] mintree;
    public static void main(String[] args) throws IOException {
//       Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
       List<Integer> arr = new ArrayList<>();
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
       arr.add(0);
       for(int i = 1; i<=n; i++) {
    	   int num = Integer.parseInt(br.readLine());
    	   arr.add(i, num);
       }
       mintree = new int[n*4];
       init_min(1, n, 1, arr);  
       
       for(int i = 0 ; i<m; i++) {
    	   st = new StringTokenizer(br.readLine());
    	   int a = Integer.parseInt(st.nextToken());
    	   int b = Integer.parseInt(st.nextToken());
    	   System.out.println(min_num(1, n, 1, a, b));
       }
    }
     static int init_min(int start, int end, int node, List<Integer> space){
       if(start == end){
          return mintree[node]=space.get(start);
       }
       
       int mid = (start+end)/2;
       
       return mintree[node]= Math.min(init_min(start, mid, node*2, space) , init_min(mid+1, end, node*2+1,space));
    }
     static int min_num(int start, int end, int node, int left, int right){
       if(start>right || end<left){
          return Integer.MAX_VALUE;
       }
       if(left<=start && end<=right){
          return mintree[node];
       }
       int mid = (start+end)/2;
       
       return Math.min(min_num(start,mid,node*2,left,right), min_num(mid+1,end,node*2+1,left,right));
    }
}
