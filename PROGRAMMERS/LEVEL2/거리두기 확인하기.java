import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[][] p = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(solution(p)));
    }

    static int[] dx = {0,1,0,-1, 2,0,-2,0, 1,-1,-1,1};
    static int[] dy = {1,0,-1,0, 0,2,0,-2, 1,1,-1,-1};


    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int i = 0; i<5; i++) {
            String[][] maps = new String[5][5];
            for(int j = 0; j<5; j++) {
                maps[j] = places[i][j].split("");
            }

            if(check(maps))
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        return answer;
    }

    public static boolean check(String[][] maps) {
        for(int i = 0; i<5; i++) {
            for(int j = 0; j<5; j++) {
                //사람이 있으면 거리 준수하는지 체크.
                if(maps[i][j].equals("P")) {
                    for(int k = 0; k<12; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx >= 0 && ny >=0 && nx < 5 && ny < 5) {
                            if(maps[nx][ny].equals("P")) {
                                //바로 옆칸이 사람이면 false
                                if (k < 4) {
                                    return false;
                                }

                                //2칸 뒤가 사람이면 그방향 바로 옆이 파티션인지 체크
                                else if(k == 4) {
                                    if(!maps[i+1][j].equals("X")) {
                                        return false;
                                    }
                                }
                                else if(k == 5) {
                                    if(!maps[i][j+1].equals("X")) {
                                        return false;
                                    }
                                }
                                else if(k == 6) {
                                    if(!maps[i-1][j].equals("X")) {
                                        return false;
                                    }
                                }
                                else if(k == 7) {
                                    if(!maps[i][j-1].equals("X")) {
                                        return false;
                                    }
                                }

                                //대각선이 사람이면 그방향 양옆 체크
                                else if (k == 8) {
                                    if (!maps[i + 1][j].equals("X") || !maps[i][j + 1].equals("X")) {
                                        return false;
                                    }
                                } else if (k == 9) {
                                    if (!maps[i][j + 1].equals("X") || !maps[i - 1][j].equals("X")) {
                                        return false;
                                    }
                                } else if (k == 10) {
                                    if (!maps[i][j - 1].equals("X") || !maps[i - 1][j].equals("X")) {
                                        return false;
                                    }
                                } else {
                                    if (!maps[i][j - 1].equals("X") || !maps[i + 1][j].equals("X")) {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

}
