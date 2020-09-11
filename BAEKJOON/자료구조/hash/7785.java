import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	HashSet<String> map = new HashSet<>();
       
    	for(int i = 0 ; i<n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		String name = st.nextToken();
    		String s = st.nextToken();
    		if(s.equals("enter"))
    			map.add(name);
    		else
    			map.remove(name);
    	}
    	
    	List<String> list = new ArrayList<>(map);
    	Collections.sort(list);
    	ListIterator<String> it = list.listIterator(list.size());
    	
    	while(it.hasPrevious()) {
    		System.out.println(it.previous());
    	}
    }
}
