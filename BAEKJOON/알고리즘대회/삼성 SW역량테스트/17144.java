import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int t = sc.nextInt();
		
		int[][] arr = new int[r][c];
		int[][] ans = new int[r][c];
		int air = 0;
		for(int i = 0; i<r; i++) {
			for(int j = 0 ; j<c; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == -1) {
					air = i;
				}
			}
		}
		
		for(int tc = 0; tc<t; tc++) {
			for(int i = 0; i<r; i++) {
				for(int j = 0 ; j<c; j++) {
					ans[i][j] = 0;
				}
			}
			//확산
			for(int i = 0; i<r; i++) {
				for(int j = 0 ; j<c; j++) {
					if(arr[i][j] != -1 && arr[i][j]!=0) {
						int cnt = 0;
						for(int a = 0 ; a<4; a++) {
							int nx = i + dx[a];
							int ny = j + dy[a];
							if(nx>=0&&ny>=0&&nx<r&&ny<c&&arr[nx][ny]!=-1) {
								ans[nx][ny] += arr[i][j]/5;
								cnt++;
							}
						}
						ans[i][j] += arr[i][j] - (arr[i][j]/5)*cnt;
					}
				}
			}
			ans[air-1][0] = -1;
			ans[air][0] = -1;
			for(int i = 0 ; i<r; i++) {
				for(int j = 0 ; j<c; j++) {
					arr[i][j] = ans[i][j];
				}
			}
			
			//첫번째 순환
			//오른쪽 순환
			int right = arr[air-1][c-1];
			for(int i = c-1; i>1; i--) {
				arr[air-1][i] = arr[air-1][i-1];
			}
			arr[air-1][1] = 0;

			//위쪽 순환
			int up = arr[0][c-1];
			for(int i = 0; i<air-2; i++) {
				arr[i][c-1] = arr[i+1][c-1];
			}
			arr[air-2][c-1] = right;

			//왼쪽 순환
			int left = arr[0][0];
			for(int i = 0; i<c-1; i++) {
				arr[0][i] = arr[0][i+1];
			}
			arr[0][c-2] = up;

			//아래로 순환
			for(int i = air-2; i>0; i--) {
				arr[i][0] = arr[i-1][0];
			}
			arr[1][0] = left;
			
			
			//두번째 순환
			//오른쪽 순환
			right = arr[air][c-1];
			for(int i = c-1; i>1; i--) {
				arr[air][i] = arr[air][i-1];
			}
			arr[air][1] = 0;
			
			//아래로 순환
			int down = arr[r-1][c-1];
			for(int i = r-1; i>air; i--) {
				arr[i][c-1] = arr[i-1][c-1];
			}
			arr[air+1][c-1] = right;
			
			//왼쪽 순환
			left = arr[r-1][0];
			for(int i = 0; i<c-1; i++) {
				arr[r-1][i] = arr[r-1][i+1];
			}
			arr[r-1][c-2] = down;
			
			//위쪽 순환
			for(int i = air+1; i<r-1; i++) {
				arr[i][0] = arr[i+1][0];
			}
			arr[r-2][0] = left;
		}
		
		int answer = 0;
		for(int i = 0; i<r; i++) {
			for(int j = 0 ; j<c; j++) {
				answer += arr[i][j];
			}
		}
		System.out.println(answer+2);
	}
}
