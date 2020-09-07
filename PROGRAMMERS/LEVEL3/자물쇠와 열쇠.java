import java.io.*;
import java.util.*;
class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
		int[][] arr = new int[2*key.length+lock.length][2*key.length+lock.length];
		int a = 0, b = 0;
		for(int i = key.length ; i<key.length+lock.length; i++) {
			for(int j = key.length; j<key.length+lock.length; j++) {
				arr[i][j] = lock[a][b];
				b++;
			}
			a++;
			b = 0;
		}
        int end = 0;
		for(int i = 0; i<lock.length; i++){
            for(int j = 0 ; j<lock.length; j++){
                if(lock[i][j] == 0){
                    end = 1;
                    break;
                }
            }
        }
        if(end == 0){
            answer = true;
            return answer;
        }
        
		for(int t = 0 ; t<4; t++) {
			key = rotate(key);
			int x = 0, y = 0;
			
			while(true) {
				if(x==key.length+lock.length+1)
					break;
				int[][] arr2 = new int[arr.length][arr.length];
				for(int i = 0; i<arr2.length; i++) {
					arr2[i] = arr[i].clone();
				}
				a = 0;
				b = 0;
				for(int i = x; i<x+key.length; i++) {
					for(int j = y; j<y+key.length; j++) {
						arr2[i][j] += key[a][b];
						b++;
					}
					a++;
					b = 0;
				}
				boolean ch = check(arr2, key.length, lock.length);
				if(ch == true) {
                    answer = true;
                    return answer;
				}
				if(y==key.length+lock.length) {
					x++;
					y = 0;
				}
				else {
					y++;
				}
			}
		}
        answer = false;
        return answer;
    }
    
    static int[][] rotate(int[][] arr){
    	int[][] rotate = new int[arr.length][arr.length];
    	for(int i = 0 ; i<rotate.length; i++) {
    		for(int j = 0 ; j<rotate.length; j++) {
    			rotate[i][j] = arr[arr.length-1-j][i];
    		}
    	}
    	return rotate;
    }
    
    static boolean check(int[][] arr, int m, int n) {
    	int num = 0;
    	for(int i = m; i<m+n; i++) {
    		for(int j = m; j<m+n; j++) {
    			if(arr[i][j] != 1) {
    				num = 1;
    				return false;
    			}
    		}
    	}
    	if(num == 0)
    		return true;
    	else
    		return false;
    }
}
