import java.io.*;
import java.util.*;


public class Main {
   static long[] mintree;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
       	int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long[] arr = new long[n+1];
       for(int i = 1; i<=n; i++) {
    	   arr[i] = Long.parseLong(br.readLine());
       }
       mintree = new long[n*4];
       init_mul(1,n,1,arr);
       StringBuilder sb = new StringBuilder();
       for(int i = 0 ; i<m+k; i++) {
    	   st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
    	   int b = Integer.parseInt(st.nextToken());
    	   long c = Integer.parseInt(st.nextToken());
    	   if(a==1) {
    		   arr[b] = c;
    		   update(1, n, 1, b, c);
    	   }
    	   else {
    		   sb.append(mul_num(1,n,1,b,(int)c) + "\n");
    	   }
       }
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
    }
     static long init_mul(int start, int end, int node, long[] arr){
       if(start == end){
          return mintree[node] = arr[start];
       }
       
       int mid = (start+end)/2;
       
       return mintree[node]= (init_mul(start, mid, node*2, arr) * init_mul(mid+1, end, node*2+1,arr)) % 1000000007;
    }
     
     static long mul_num(int start, int end, int node, int left, int right){
       if(start>right || end<left){
          return 1;
       }
       if(left<=start && end<=right){
          return mintree[node];
       }
       int mid = (start+end)/2;
       
       return (mul_num(start,mid,node*2,left,right) * mul_num(mid+1,end,node*2+1,left,right)) % 1000000007;
    }
     
     static long update(int start, int end, int node, int idx, long dif) {
    	 if(idx < start || idx > end) {
    		 return mintree[node];
    	 }
    	 
    	 if(start == end) {
    		 return mintree[node] = dif;
    	 }
    	 
    	 int mid = (start + end) / 2;
    	 return mintree[node] = update(start ,mid, node*2, idx, dif)*update(mid+1, end, node*2+1, idx, dif) % 1000000007;
     }
}
