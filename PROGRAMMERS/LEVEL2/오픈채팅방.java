import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	String[] arr = new String[n];
    	for(int i = 0; i<n; i++) {
    		arr[i] = br.readLine();
    	}
    	String[] answer;
    	answer = solution(arr);
    	for(int i = 0 ; i<answer.length; i++) {
    		System.out.println(answer[i]);
    	}
    }
    
    public static String[] solution(String[] record) {
    	HashMap<String, String> map = new HashMap<>();
    	ArrayList<String> log = new ArrayList<>();
    	for(int i = 0 ; i<record.length; i++) {
    		String[] st;
    		st = record[i].split(" ");
    		if(st[0].equals("Enter")) {
    			map.put(st[1], st[2]);
    			log.add(st[1] + "님이 들어왔습니다.");
    		}
    		else if(st[0].equals("Leave")) {
    			log.add(st[1] + "님이 나갔습니다.");
    		}
    		else {
    			map.put(st[1], st[2]);
    		}	
    	}
        String[] answer = new String[log.size()];
        int i = 0;
        for(String str: log) {
        	int idx = str.indexOf("님");
        	String id = str.substring(0, idx);
        	answer[i] = str.replace(id, map.get(id));
        	i++;
        }       
        return answer;
    }
}
