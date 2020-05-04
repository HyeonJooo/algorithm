//백준 알고리즘 14891번 : 톱니바퀴
import java.io.*;
import java.util.*;
public class Main {
	static int[] dir = new int[4];//각 톱니바퀴 회전유무
    public static void main(String[] args) throws IOException {
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
    	int[][] arr = new int[4][8];

    	for(int i = 0; i<4; i++) {
            String[] s =br.readLine().split("");
            for(int j = 0; j<8; j++) {
            	arr[i][j] = Integer.parseInt(s[j]); 
            }
    	}
    	int k = Integer.parseInt(br.readLine());//회전횟수
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
    		
    		for(int i = num; i<4; i++) {
    			if(arr[i-1][2] != arr[i][6]) {
    				dir[i] = -dir[i-1];
    			}
    			else
    				break;
    		}
    		
    		for(int i = 0; i<4; i++) {
    			if(dir[i] == 1) {//시계방향으로 회전
    				int tmp = arr[i][7];
    				for(int j = 7 ; j>0; j--) {
    					arr[i][j] = arr[i][j-1];
    				}
    				arr[i][0] = tmp;
				}
    			
    			else if(dir[i] == -1) {//반시계
    				int tmp = arr[i][0];
    				for(int j = 0; j<7; j++) {
    					arr[i][j] = arr[i][j+1];
    				}
    				arr[i][7] = tmp;
    			}
    			else
    				continue;
    		}
    		for(int i = 0; i<4; i++) {
    			dir[i] = 0;
    		}
    	}
    	int sum = 0;
    	if(arr[0][0]==1)
    		sum += 1;
    	if(arr[1][0]==1)
    		sum += 2;
    	if(arr[2][0]==1)
    		sum += 4;
    	if(arr[3][0]==1)
    		sum += 8;
    	System.out.println(sum);
    }
}
