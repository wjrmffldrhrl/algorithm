package solved.P16472_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P16472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] talk = br.readLine().toCharArray();
        Map<Character, Integer> wordCount = new HashMap<>();
        add(wordCount, talk[0]);

        int answer = 0;
        int frontIndex = 0;
        for (int backIndex = 1; backIndex < talk.length; backIndex++) {
//            System.out.println("backIndex " + backIndex);
//            System.out.println("add " + talk[backIndex]);
            add(wordCount, talk[backIndex]);

            while (wordCount.keySet().size() > N) {
//                System.out.println("remove " + talk[frontIndex]);
                remove(wordCount, talk[frontIndex++]);

//                System.out.println("readd " + talk[frontIndex]);

//                System.out.println("size " + wordCount.size());

            }

//            System.out.println("frontIndex " + frontIndex);

            answer = Math.max(answer, backIndex - frontIndex + 1 );
//            System.out.println();

        }

        System.out.println(answer);
    }

    public static void add(Map<Character, Integer> wordCount, char word) {

        int count = 1;
        if (wordCount.containsKey(word)) {
//            System.out.println("already contain ");
            count = wordCount.get(word) + 1;
//            System.out.println("count " + count);
        }

        wordCount.put(word, count);
    }

    public static void remove(Map<Character, Integer> wordCount, char word) {

        int count = wordCount.get(word);

        if ( count == 1) {
//            System.out.println("remove key " + word);
            wordCount.remove(word);
        } else {
            wordCount.put(word, count - 1);
        }
    }
}
