//백준 알고리즘 15662번 : 톱니바퀴(2)
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine()); 
    	int[][] arr = new int[t][8];
    	int[] dir = new int[t];
    	for(int i = 0; i<t; i++) {
			dir[i] = 0;
		}
    	for(int i = 0; i<t; i++) {
            String[] s =br.readLine().split("");
            for(int j = 0; j<8; j++) {
            	arr[i][j] = Integer.parseInt(s[j]); 
            }
    	}
    	int k = Integer.parseInt(br.readLine());
    	while(k-- > 0){
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int num = Integer.parseInt(st.nextToken());//몇번바퀴
    		int d = Integer.parseInt(st.nextToken());//회전방향
    		dir[num-1] = d;
    		
    		for(int i = num-1; i>0; i--) {
    			if(arr[i-1][2] != arr[i][6]) {
    				dir[i-1] = -dir[i];
    			}
    			else
    				break;
    		}
    		
    		for(int i = num; i<t; i++) {
    			if(arr[i-1][2] != arr[i][6]) {
    				dir[i] = -dir[i-1];
    			}
    			else
    				break;
    		}
    		
    		for(int i = 0; i<t; i++) {
    			if(dir[i] == 1) {
    				int tmp = arr[i][7];
    				for(int j = 7 ; j>0; j--) {
    					arr[i][j] = arr[i][j-1];
    				}
    				arr[i][0] = tmp;
				}
    			
    			else if(dir[i] == -1) {
    				int tmp = arr[i][0];
    				for(int j = 0; j<7; j++) {
    					arr[i][j] = arr[i][j+1];
    				}
    				arr[i][7] = tmp;
    			}
    			else
    				continue;
    		}
    		for(int i = 0; i<t; i++) {
    			dir[i] = 0;
    		}
    	}
    	int sum = 0;
    	for(int i = 0 ; i<t; i++) {
    		if(arr[i][0]==1)
    			sum+=1;
    	}
    	System.out.println(sum);
    }
}
