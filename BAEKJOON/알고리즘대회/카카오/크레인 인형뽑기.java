//2019 카카오 개발자 겨울 인턴십
import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
		int answer = 0;
		
        for(int i = 0 ; i<moves.length; i++) {
			for(int j = 0; j<board.length; j++) {
				if(board[j][moves[i]-1] == 0)
					continue;
				else {
					if(!stack.isEmpty() && stack.peek() == board[j][moves[i]-1]) {
						stack.pop();
						answer += 2;
					}
					
					else 
						stack.push(board[j][moves[i]-1]);
					
					board[j][moves[i]-1] = 0;					
					break;
				}
			}
		}
        return answer;
    }
}
