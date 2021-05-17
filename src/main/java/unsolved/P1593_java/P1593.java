package unsolved.P1593_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1593 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int g = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        String W = br.readLine();
        String S = br.readLine();

        int[] wordCount = new int[60];
        for (char word : W.toCharArray()) {
            wordCount[word - 'A']++;
        }

        int count = 0;
        for (int i = 0; i < s - g; i++) {
            if (isMaya(g, S, wordCount, i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isMaya(int g, String S, int[] wordCount, int i) {
        int[] tmpWordCount =  new int[60];

        for (int j = 0; j < g; j++) {
            tmpWordCount[S.charAt(i + j) - 'A']++;
        }


        for (int j = 0; j < tmpWordCount.length; j++) {
            if (wordCount[j] != tmpWordCount[j]) {
                return false;
            }

        }
        return true;
    }

}
