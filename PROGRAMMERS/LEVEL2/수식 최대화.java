import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Long> nums = new ArrayList<Long>();
	static ArrayList<Character> exp = new ArrayList<Character>();
	static long answer;
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	String expression = "50*6-3*2";
    	System.out.println(solution(expression));
    	
    }
    public static long solution(String expression) {
        answer = 0;
        int plus = 0, minus = 0, mul = 0;
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0 ; i<expression.length(); i++) {
        	if(plus==1 && minus==1 && mul==1)
        		break;
        	
        	if(expression.charAt(i)=='+' && plus!=1) {
        		plus = 1;
        		list.add("+");
        	}

        	else if(expression.charAt(i)=='-' && minus!=1) {
        		minus = 1;
        		list.add("-");
        	}

        	else if(expression.charAt(i)=='*' && mul!=1) {
        		mul = 1;
        		list.add("*");
        	}
        	else
        		continue;
        }
        String num = "";
        for(int i = 0 ; i<expression.length(); i++) {
        	if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
        		num += expression.charAt(i);
        	}
        	else {
        		nums.add(Long.parseLong(num));
        		num = "";
        		exp.add(expression.charAt(i));
        	}
        }
        nums.add(Long.parseLong(num));
        
        String[] exp = new String[list.size()];
        for(int i = 0 ; i<exp.length; i++) {
        	exp[i] = list.get(i);
        }
        permutation(exp, 0,exp.length,exp.length);

        
        
        return answer;
    }
    
    static void permutation(String[] arr, int depth, int n, int r) {
    	if(depth == r) {//우선순위 정해짐
    		ArrayList<Long> nums2 = new ArrayList<Long>(nums);
    		ArrayList<Character> exp2 = new ArrayList<Character>(exp);
    		
    		for(int i = 0; i<arr.length; i++){
    			for(int j = 0 ; j<exp2.size(); j++) {
    				if(arr[i].equals(exp2.get(j).toString())) {
    					Long ans = cal(nums2.remove(j), nums2.remove(j), arr[i]);
    					nums2.add(j, ans);
    					exp2.remove(j);
    					j--;
    				}
    			}
    		}
    		answer = Math.max(answer,  Math.abs(nums2.get(0)));
    	}
    	
    	for(int i = depth; i<n; i++) {
    		swap(arr, depth, i);
    		permutation(arr, depth+1, n, r);
    		swap(arr, depth, i);
    	}
    }
    
    static void swap(String[] arr, int depth, int i) {
    	String tmp = arr[depth];
    	arr[depth] = arr[i];
    	arr[i] = tmp;
    }
    
    static Long cal(Long num1, Long num2, String op) {
    	long num = 0;
    	if(op.equals("+"))
    		return num1 + num2;
    	else if(op.equals("-"))
    		return num1 - num2;
    	else if(op.equals("*"))
    		return num1 * num2;
    	return num;
    }
}
