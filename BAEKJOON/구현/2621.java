import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] color = new String[5];
        int[] score = new int[5];
        int[] scoreTemp = new int[5];
        int[] scoreCount = new int[10];
        int[] colorCount = new int[4];
        int answer = 0;

        for (int i = 0; i < 5; i++) {
            color[i] = sc.next();
            score[i] = sc.nextInt();
            scoreTemp[i] = score[i];
            scoreCount[score[i]]++;
            if(color[i].equals("R"))
                colorCount[0]++;
            else if(color[i].equals("B"))
                colorCount[1]++;
            else if(color[i].equals("Y"))
                colorCount[2]++;
            else
                colorCount[3]++;
        }
        Arrays.sort(scoreTemp);
        int isAllSameColor = 0;
        for(int i = 0 ; i<4; i++) {
            if(colorCount[i] == 0)
                isAllSameColor++;
        }

        int isAllSameScore = 0;
        for(int i = 1; i<10; i++) {
            if(scoreCount[i] != 0)
                isAllSameScore++;
        }

        boolean isConScore = true;
        for(int i = 0; i<4; i++) {
            if(scoreTemp[i+1] - scoreTemp[i] != 1) {
                isConScore = false;
                break;
            }
        }

        boolean isThree = false;
        int score3 = 0;
        boolean isTwo = false;
        int score2 = 0;
        for(int i = 1; i<10; i++) {
            if(scoreCount[i] == 3) {
                isThree = true;
                score3 = i;
            }
            else if(scoreCount[i] == 2) {
                isTwo = true;
                score2 = i;
            }
        }

        boolean isTwoSame1 = false;
        boolean isTwoSame2 = false;
        int twoScore1 = 0;
        int twoScore2 = 0;
        for(int i = 1; i<10; i++) {
            if(!isTwoSame1 && scoreCount[i] == 2) {
                isTwoSame1 = true;
                twoScore1 = i;
                continue;
            }
            if(isTwoSame1 && !isTwoSame2 && scoreCount[i] == 2) {
                isTwoSame2 = true;
                twoScore2 = i;
                break;
            }
        }
        int isAllDif = 0;
        for(int i = 1; i<10; i++) {
            if(scoreCount[i] == 1)
                isAllDif++;
        }

        //카드 5장이 모두 같은 색인 경우
        if(isAllSameColor == 3) {
            // 규칙1. 숫자가 연속적인 경우
            if(isConScore) {
                System.out.println(scoreTemp[4] + 900);
                System.exit(0);
            }

            // 규칙4. 색깔 모두 같을 때.
            else {
                System.out.println(scoreTemp[4] + 600);
                System.exit(0);
            }
        }

        for(int i = 1; i<10; i++) {
            // 규칙 2. 4장의 숫자가 같을 때
            if(scoreCount[i] == 4) {
                answer = i + 800;
            }
        }

        // 규칙 3. 5장 중 3장숫자 같고 2장숫자 같은경우
        if(isThree && isTwo) {
            answer = Math.max(answer, (score3*10)+score2+700);
        }

        // 규칙 5. 5장 숫자가 연속적인 경우
        else if(isConScore) {
            answer = Math.max(answer, scoreTemp[4] + 500);
        }

        // 규칙 6. 5장 중 3장만 같은 경우
        else if(isThree && !isTwo) {
            answer = Math.max(answer, score3+400);
        }

        // 규칙 7. 5장 중 2장숫자 같고, 또다른 2장이 같은 경우
        else if(isTwoSame1 && isTwoSame2) {
            answer = Math.max(answer, twoScore2*10 + twoScore1 + 300);
        }

        // 규칙 8. 2장숫자 같을 때.
        else if(!isThree && !isTwoSame2 && isAllDif!=5) {
            answer = Math.max(answer, twoScore1+200);
        }

        // 규칙 9. 어떤 경우 해당 x
        else {
            answer = Math.max(answer, scoreTemp[4]+100);
        }
        System.out.println(answer);
    }
}
