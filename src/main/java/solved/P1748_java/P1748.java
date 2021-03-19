package solved.P1748_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        int answer = 0;
        int startLength = n.length() - 1;

        int numberLength = 1;
        int i;
        for (i = 0; i < startLength; i++) {
            answer += numberLength * 9 * (i + 1);
            numberLength *= 10;
        }


        answer += (Integer.parseInt(n) - numberLength + 1) * (i + 1);


        System.out.println(answer);

    }

}