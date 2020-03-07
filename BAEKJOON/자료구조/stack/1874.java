//백준 알고리즘 1872번 : 스택 수열
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] sortarr = new int[n];
        for(int i = 0 ; i<arr.length; i++) {
        	arr[i] = sc.nextInt();
        	sortarr[i] = arr[i];
        }
        Arrays.sort(sortarr);
		stack.push(sortarr[0]);
		StringBuilder ans = new StringBuilder("+" + "\n");
		int a = 1;
        for(int i = 0; i<n; i++) {
        	for(int j = a; j<n; j++) {
        		if(!stack.isEmpty() && stack.peek() == arr[i]) {
        			stack.pop();
        			ans.append('-' +"\n");
        			break;
        		}
        		else if(!stack.isEmpty() && stack.peek() > arr[i]) {
        			System.out.println("NO");
        			System.exit(0);
        		}
        		else {
        			stack.push(sortarr[j]);
        			ans.append('+' + "\n");
        			a++;
        		}
        		
        	}
        	if(!stack.isEmpty() && stack.peek() == arr[i]) {
    			stack.pop();
    			ans.append('-'+"\n");
    		}

        	else if(!stack.isEmpty() && stack.peek() > arr[i]) {
    			System.out.println("NO");
    			System.exit(0);
    		}
        	
        	else if(!stack.isEmpty() || i != n-1)
        		continue;
        	
        	else {
        		System.out.println("NO");
        		System.exit(0);
        	}
        }
        System.out.println(ans);
    }
}
