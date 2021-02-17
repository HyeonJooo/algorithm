import java.io.*;
import java.util.*;
public class Main {
	static boolean[][] check;
	static boolean[][] visit;
	static String[][] arr;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int cnt = 0;
	static Queue<int[]> Rqueue = new LinkedList<int[]>();
	static Queue<int[]> Gqueue = new LinkedList<int[]>();
	static Queue<int[]> Bqueue = new LinkedList<int[]>();
	static Queue<int[]> Yqueue = new LinkedList<int[]>();
	static Queue<int[]> Pqueue = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        arr = new String[12][6];
        check = new boolean[12][6];
        visit = new boolean[12][6];
        for(int i = 0 ; i<12; i++) {
        	String s = sc.next();
        	arr[i] = s.split("");
        }
        int answer = 0;
        
        while(true) {
            int answerCnt = 0;
            for(int i = 0 ; i<12; i++) {
            	for(int j = 0 ; j<6; j++) {
            		if(!arr[i][j].equals(".") && !visit[i][j]) {
            			bfs(i,j);
            			if(cnt >= 4) {
            				if(arr[i][j].equals("R")) {
            					while(!Rqueue.isEmpty()) {
                					int qx = Rqueue.peek()[0];
                					int qy = Rqueue.peek()[1];
                					check[qx][qy] = true;
                					Rqueue.poll();
                				}
            				}
            				else if(arr[i][j].equals("G")) {
            					while(!Gqueue.isEmpty()) {
                					int qx = Gqueue.peek()[0];
                					int qy = Gqueue.peek()[1];
                					check[qx][qy] = true;
                					Gqueue.poll();
            					}
            				}
            				else if(arr[i][j].equals("B")) {
            					while(!Bqueue.isEmpty()) {
                					int qx = Bqueue.peek()[0];
                					int qy = Bqueue.peek()[1];
                					check[qx][qy] = true;
                					Bqueue.poll();
            					}
            				}
            				else if(arr[i][j].equals("Y")) {
            					while(!Yqueue.isEmpty()) {
                					int qx = Yqueue.peek()[0];
                					int qy = Yqueue.peek()[1];
                					check[qx][qy] = true;
                					Yqueue.poll();
            					}
            				}
            				else if(arr[i][j].equals("P")) {
            					while(!Pqueue.isEmpty()) {
                					int qx = Pqueue.peek()[0];
                					int qy = Pqueue.peek()[1];
                					check[qx][qy] = true;
                					Pqueue.poll();
            					}
            				}
        					answerCnt = 1;
            			}
            			
            			else {
            				if(arr[i][j].equals("R")) {
            					while(!Rqueue.isEmpty()) {
                					Rqueue.poll();
                				}	
            				}
            				else if(arr[i][j].equals("G")) {
            					while(!Gqueue.isEmpty()) {
                					Gqueue.poll();
            					}
            				}
            				else if(arr[i][j].equals("B")) {
            					while(!Bqueue.isEmpty()) {
                					Bqueue.poll();
            					}
            				}
            				else if(arr[i][j].equals("Y")) {
            					while(!Yqueue.isEmpty()) {
                					Yqueue.poll();
            					}
            				}
            				else if(arr[i][j].equals("P")) {
            					while(!Pqueue.isEmpty()) {
                					Pqueue.poll();
            					}
            				}
            			}
            		}
            		cnt = 0;
            	}
            }
            if(answerCnt == 1) {
                for(int i = 0 ; i<12; i++) {
                	for(int j = 0 ; j<6; j++) {
                		if(check[i][j] == true) {
                			if(i!=0) {
                				for(int k = i; k>0; k--) {
                					arr[k][j] = arr[k-1][j];//위에서 뿌요 떨어짐
                				}
                				arr[0][j] = ".";
                			}
                			else {//가장 윗줄
                				arr[i][j] = ".";
                			}
                			check[i][j] = false;
                		}
                	}
                }
                answer++;
                reset();
            }
            
            else
            	break;
        }
        System.out.println(answer);
        
    }
	
	static void reset() {
		for(int i = 0; i<12; i++) {
			for(int j = 0 ; j<6; j++) {
				visit[i][j] = false;
				check[i][j] = false;
			}
		}
	}
	
	static void bfs(int x, int y) {
		String puyo = arr[x][y];
    	Queue<int[]> queue = new LinkedList<int[]>();

    	queue.offer(new int[] {x,y});    
    	
    	while(!queue.isEmpty()) {
    		int qx = queue.peek()[0];
        	int qy = queue.peek()[1];
            queue.poll();
                
            for(int j = 0; j<4; j++) {
                int nx = qx + dx[j];
                int ny = qy + dy[j];

                if(nx<0 || ny<0 || nx>=12 || ny>=6)//범위 밖이면 건너뜀
                	continue;
                	
                if(visit[nx][ny])//이미 방문한 곳이면 건너뜀
               		continue;
                
                if(arr[nx][ny].equals("."))//빈 공간이면 건너뜀
                	continue;
                
                if(arr[nx][ny].equals(puyo) && arr[nx][ny].equals("R")) {
                    Rqueue.offer(new int[] {nx,ny});               	
                    queue.offer(new int[] {nx,ny});     
                   	visit[nx][ny] = true;
                   	cnt++;
                }
                else if(arr[nx][ny].equals(puyo) && arr[nx][ny].equals("G")) {
                	Gqueue.offer(new int[] {nx,ny});               	
                    queue.offer(new int[] {nx,ny});  
                   	visit[nx][ny] = true;
                   	cnt++;
                }

                else if(arr[nx][ny].equals(puyo) && arr[nx][ny].equals("B")) {
                	Bqueue.offer(new int[] {nx,ny});               	
                    queue.offer(new int[] {nx,ny}); 
                   	visit[nx][ny] = true;
                   	cnt++;
                }

                else if(arr[nx][ny].equals(puyo) && arr[nx][ny].equals("Y")) {
                	Yqueue.offer(new int[] {nx,ny});               	
                    queue.offer(new int[] {nx,ny}); 
                   	visit[nx][ny] = true;
                   	cnt++;
                }

                else if(arr[nx][ny].equals(puyo) && arr[nx][ny].equals("P")) {
                	Pqueue.offer(new int[] {nx,ny});               	
                    queue.offer(new int[] {nx,ny});       
                   	visit[nx][ny] = true;
                   	cnt++;
                }
        	}    			
    	}
	}
}
