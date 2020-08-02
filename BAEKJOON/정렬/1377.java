import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] arr = new Point[n];
        for(int i = 0; i<n; i++) {
        	arr[i] = new Point();
        	arr[i].value = sc.nextInt();
        	arr[i].index = i;
        }
        Arrays.sort(arr);
        
        int max = 0;
        for(int i = 0 ; i<n; i++) {
        	if(max < arr[i].index - i)
        		max = arr[i].index - i;
        }
        System.out.println(max+1);
        }       
    }
class Point implements Comparable<Point>{
    	int value;
    	int index;
    	
    	@Override
    	public int compareTo(Point o) {
    		return this.value-o.value;
    	}
    }
