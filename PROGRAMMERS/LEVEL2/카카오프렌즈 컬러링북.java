import java.util.*;

class Solution {
    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visit = new boolean[m][n];
        int cnt = 1;

        for(int i = 0; i<m; i++) {
            for(int j = 0 ; j<n; j++) {
                if(!visit[i][j] && picture[i][j] != 0) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    visit[i][j] = true;
                    cnt = 1;
        
                    while(!queue.isEmpty()) {
                    int qx = queue.peek()[0];
                    int qy = queue.peek()[1];
                    queue.poll();

                    for(int a = 0; a<4; a++) {
                        int nx = qx + dx[a];
                        int ny = qy + dy[a];

                        if(nx >=0 && ny >= 0 && nx < m && ny < n) {
                            if(!visit[nx][ny] && picture[nx][ny] == picture[qx][qy]) {
                                queue.add(new int[]{nx,ny});
                                visit[nx][ny] = true;
                                cnt++;
                            }
                        }
                    }
                }
                numberOfArea++;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
