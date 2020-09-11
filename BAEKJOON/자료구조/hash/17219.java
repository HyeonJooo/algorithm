import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st1 = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st1.nextToken());
    	int m = Integer.parseInt(st1.nextToken());
    	HashMap<String, String> map = new HashMap<>();
    	for(int i = 0; i<n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	map.put(st.nextToken(),st.nextToken());
    	}
    	for(int i = 0; i<m; i++) {
    		String s = br.readLine();
    		bw.write(map.get(s) + "\n");
    	}
    	bw.flush();
    	bw.close();
    	br.close();
    }    
}
