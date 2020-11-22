import java.io.*;
import java.util.*;
class Temp implements Comparable<Temp>{
    int num;
    int fre;
 
    public Temp(int num, int fre) {
        this.num = num;
        this.fre = fre;
    }
 
    @Override
    public int compareTo(Temp o) {
        int r = this.fre - o.fre;
        if(r == 0) r =     this.num - o.num;
        return r;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int r = sc.nextInt();
    	int c = sc.nextInt();
    	int k = sc.nextInt();
    	int[][] arr = new int[3][3];
    	for(int i = 0 ; i<3; i++) {
    		for(int j = 0 ; j<3; j++) {
    			arr[i][j] = sc.nextInt();
    		}
    	}
    	int answer = 0;
    	List<Temp> list;
    	while(true) {
    		if(answer > 100) {
    			System.out.println(-1);
    			System.exit(0);
    		}
    		
    		if(r-1<arr.length && c-1<arr[0].length) {
    			if(arr[r-1][c-1] == k)
    				break;
    		}
    		
			int[][] temp = new int[101][101];
			int row = arr.length;
			int col = arr[0].length;
			
    		if(row >= col) {//행 정렬
    			int length = 0;
    			
    			for(int i = 0 ; i<row; i++) {
    				int[] colarrTemp = new int[col];
    				int zero = 0;
        			for(int j = 0; j<col; j++) {
        				colarrTemp[j] = arr[i][j];
        				if(arr[i][j] == 0)
        					zero++;
        			}
    				Arrays.sort(colarrTemp);
    				int[] colarr = Arrays.copyOfRange(colarrTemp, zero, col);
    				
    				int num = colarr[0];
    				int cnt = 1;
    				list = new ArrayList<>();
    				
    				for(int j = 1; j<colarr.length; j++) {
    					if(colarr[j] == num)
    						cnt++;
    					else {
    						list.add(new Temp(num, cnt));
    						num = colarr[j];
    						cnt = 1;
    					}
    				}
					list.add(new Temp(num, cnt));
					length = Math.max(length, list.size()*2);
					if(length>100)
						length = 100;
					Collections.sort(list);
					
					int a = 0;
					for(int j = 0; j<list.size(); j++) {
						temp[i][a++] = list.get(j).num;
						temp[i][a++] = list.get(j).fre;
					}
    			}
    			
    			arr = new int[row][length];
    			for(int i = 0 ; i<row; i++) {
    				for(int j = 0 ; j<length; j++) {
    					arr[i][j] = temp[i][j];
    				}
    			}
    		}

    		else {//열정렬
    			int length = 0;
    			
    			for(int i = 0 ; i<col; i++) {
    				int[] rowarrTemp = new int[row];
    				int zero = 0;
    				for(int j = 0; j<row; j++) {
    					rowarrTemp[j] = arr[j][i];
    					if(arr[j][i] == 0)
    						zero++;
    				}
    				Arrays.sort(rowarrTemp);
    				int[] rowarr = Arrays.copyOfRange(rowarrTemp, zero, row);
    				
    				int num = rowarr[0];
    				int cnt = 1;
    				list = new ArrayList<>();

    				for(int j = 1; j<rowarr.length; j++) {
    					if(rowarr[j] == num)
    						cnt++;
    					else {
    						list.add(new Temp(num, cnt));
    						num = rowarr[j];
    						cnt = 1;
    					}
    				}
					list.add(new Temp(num, cnt));
					length = Math.max(length, list.size()*2);
					if(length>100)
						length = 100;
					Collections.sort(list);
					
					int a = 0;
					for(int j = 0; j<list.size(); j++) {
						temp[a++][i] = list.get(j).num;
						temp[a++][i] = list.get(j).fre;
					}
    			}
    			
    			arr = new int[length][col];
    			for(int i = 0 ; i<length; i++) {
    				for(int j = 0 ; j<col; j++) {
    					arr[i][j] = temp[i][j];
    				}
    			}
    		}
    		
    		answer++;
    	}
    	System.out.println(answer);
    }
}
