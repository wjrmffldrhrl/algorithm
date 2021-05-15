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
        for (int i = 0; i < S.length() - g; i++) {
            boolean isMaya = true;
            int[] tmpWordCount =  new int[60];
            System.arraycopy(wordCount, 0, tmpWordCount, 0, wordCount.length);

            char[] charArray = S.substring(i, i + g).toCharArray();
            for (char word : charArray) {
                if (tmpWordCount[word - 'A'] == 0) {
                    isMaya = false;
                    break;
                } else {
                    tmpWordCount[word - 'A']--;
                }
            }

            if (isMaya) {
                count++;
            }

        }

        System.out.println(count);
    }

}
