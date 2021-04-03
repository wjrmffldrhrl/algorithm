package solved.P10799_java.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Main {

    static String inputString;
    static int inputLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputString = br.readLine();
        inputLength = inputString.length();
        List<Integer> laserIndexes = findIndexes("()");
        Stack<Integer> leftSideIndexes = new Stack<>();

        int answer = 0;
        for (int i = 0; i < inputLength - 1; i++) {
            String targetString = inputString.substring(i, i + 2);

            if (targetString.equals("((")) {
                leftSideIndexes.push(i);
            } else if (targetString.equals("))")) {
                int leftSideIndex = leftSideIndexes.pop();
                int rightSideIndex = i;

                long laserCount = laserIndexes.stream()
                        .filter(laserIndex -> laserIndex > leftSideIndex && laserIndex < rightSideIndex).count();

                answer += (laserCount + 1);
            }
        }

        System.out.println(answer);
    }


    public static List<Integer> findIndexes(String targetString) {
        List<Integer> indexes = new ArrayList<>();
        int index = 0;
        while (true) {
            int laserIndex = inputString.indexOf(targetString, index);

            if (laserIndex != -1) {
                indexes.add(laserIndex);
            } else {
                break;
            }
            index = laserIndex + 1;
        }

        return indexes;
    }
}
