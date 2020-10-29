import java.io.*;
import java.util.*;


public class Main {
   static int[] mintree;
   static int[] maxtree;
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       List<Integer> arr = new ArrayList<>();
       int n = sc.nextInt();
       int m = sc.nextInt();
       arr.add(0);
       for(int i = 1; i<=n; i++) {
    	   int num = sc.nextInt();
    	   arr.add(i, num);
       }
       mintree = new int[n*4];
       maxtree = new int[n*4];
       init_min(1, n, 1, arr);
       init_max(1, n, 1, arr);  
       
       for(int i = 0 ; i<m; i++) {
    	   int a = sc.nextInt();
    	   int b = sc.nextInt();
    	   System.out.println(min_num(1, n, 1, a, b) + " " + max_num(1, n, 1, a, b));
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
     
     static int init_max(int start, int end, int node, List<Integer> space){
         if(start == end){
            return maxtree[node]=space.get(start);
         }
         
         int mid = (start+end)/2;
         
         return maxtree[node]= Math.max(init_max(start, mid, node*2, space) , init_max(mid+1, end, node*2+1,space));
      }
     
     static int max_num(int start, int end, int node, int left, int right){
         if(start>right || end<left){
            return Integer.MIN_VALUE;
         }
         if(left<=start && end<=right){
            return maxtree[node];
         }
         int mid = (start+end)/2;
         
         return Math.max(max_num(start,mid,node*2,left,right), max_num(mid+1,end,node*2+1,left,right));
      }
}
