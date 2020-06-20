import java.io.*;
import java.util.*;
public class Main {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	static int list[], check[];
	static int m,n;
	static void dfs(int cnt) throws IOException {
		if(cnt == m) { 
			for(int i=0;i<m;i++) {
				bw.write(list[i]+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i =1; i<=n; i++) {
			//if(check[i]==1) continue;
			check[i]=1;
			list[cnt]=i;
			dfs(cnt+1); 
			check[i]=0;	
		}
	}
	
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);

   	   
   	   String[] s = br.readLine().split(" ");
   	   n = Integer.parseInt(s[0]);
   	   m = Integer.parseInt(s[1]);
   	   check = new int[9];
   	   list = new int[9];
   	   dfs(0);
   	   
   	   bw.flush();
   	   br.close();
   	   bw.close();
    }
}
