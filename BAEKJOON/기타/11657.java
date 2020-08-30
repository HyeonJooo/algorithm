import java.io.*;
import java.util.*;
class Time{
	int start, end, cost;
	public Time(int start, int end, int cost) {
		 this.start = start;
	     this.end = end;
	     this.cost = cost;
	}
}
public class Main {
   static int n;
   static int m;
   static long[] dist;
   static int[][] arr;
   static Time timearr[];
   private static final int INF = 500 * 100_000;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        timearr = new Time[m+1];
        dist = new long[n+1];
        for(int i =1; i<=n; i++)
        	dist[i] = INF;
        
          for(int i = 0 ; i<m; i++) {
        	 st = new StringTokenizer(br.readLine());
             int start = Integer.parseInt(st.nextToken());
             int end = Integer.parseInt(st.nextToken());
             int cost = Integer.parseInt(st.nextToken());
             timearr[i] = new Time(start, end, cost);
          }
          StringBuilder sb = new StringBuilder();
          if(!go()){
              sb.append("-1\n");
          }
          else {  
              for(int i = 2; i <= n; i++){
                  sb.append(dist[i] == INF ? "-1\n" : dist[i] + "\n");
              }
          // 음의 cycle이 있는 경우
          }
          bw.write(sb.toString());
          bw.close();
          br.close();
    }   
    static boolean go() {
    	dist[1] = 0;
    	for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                Time time = timearr[j];
                if(dist[time.start] != INF && dist[time.end] > dist[time.start] + time.cost){
                    dist[time.end] = dist[time.start] + time.cost;
                }
            }
        }

        // 음수 cycle 확인
        for(int i = 0; i < m; i++){
            Time time = timearr[i];

            if(dist[time.start] != INF &&dist[time.end] > dist[time.start] + time.cost) return false;
        }

        return true;
    }
}
