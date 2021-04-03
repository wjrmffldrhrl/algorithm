package solved.P10799_java.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

    static String inputString;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputString = br.readLine();

        boolean[] isLaser = new boolean[inputString.length()];
        Stack<Integer> leftSideIndexes = new Stack<>();

        int answer = 0;
        for (int i = 0; i < inputString.length() - 1; i++) {
            char firstTargetChar = inputString.charAt(i);
            char secondTargetChar = inputString.charAt(i + 1);

            switch (firstTargetChar) {
                case '(':
                    break;
                case ')':
            }


            if (firstTargetChar == '(') {
                if (secondTargetChar == '(') {
                    leftSideIndexes.push(i);
                } else {
                    isLaser[i] = true;
                }
            } else if (secondTargetChar == ')') {
                int leftSideIndex = leftSideIndexes.pop();
                int laserCount = getLaserCount(isLaser, leftSideIndex, i);

                answer += (laserCount + 1);
            }
        }

        System.out.println(answer);
    }

    private static int getLaserCount(boolean[] isLaser, int leftSideIndex, int rightSideIndex) {
        int laserCount = 0;
        for (int i = leftSideIndex; i < rightSideIndex; i++) {
            if (isLaser[i]) {
                laserCount++;
            }
        }

        return laserCount;
    }


}
