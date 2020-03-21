//2019 카카오 신입공채 코딩테스트
import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        double[][] ans = new double[N][2];
        for(int i = 0; i<N; i++) {
        	ans[i][0] = i+1;
        }
        
        int idx = -1;
        for(int i = 1; i<=N; i++) {
            int not = 0; //스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수
            int arrive = stages.length - idx-1; //스테이지에 도달한 플레이어 수
        	for(int j = idx+1; j<stages.length; j++) {
        		if(stages[j] == i) {
        			not++;
        			idx = j;
        		}
        		else
        			break;
        	}
        	if(arrive == 0)//스테이지에 도달한 플레이어가 없는 경우
        		ans[i-1][1] = 0;
        	else
        		ans[i-1][1] = (double) not / arrive;//실패율 정의
        }
        
        Arrays.sort(ans, new Comparator<double[]>() {

			@Override
			public int compare(double[] o1, double[] o2) {
				if(o1[1]==o2[1]) return Double.compare(o1[0], o2[0]);
				return Double.compare(o2[1], o1[1]);
			}
        });
        int[] answer = new int[N];
        for(int i = 0 ; i<N; i++) {
        	answer[i] = (int) ans[i][0];
        }
        return answer;
    }
}
