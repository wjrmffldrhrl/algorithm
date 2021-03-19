package unsolved.P12782_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputNumber; i++) {

            String NM = br.readLine();
            int spaceIndex = NM.indexOf(" ");

            int a = 0;
            int b = 0;

            for (int j = 0; j < spaceIndex; j++) {
                char n = NM.charAt(j);
                char m = NM.charAt(j + spaceIndex + 1);
                if (n == '0' && m == '1') {
                    a++;
                } else if (n == '1' && m == '0') {
                    b++;
                }
            }

            System.out.println(
                    ((a <= b) ? a : b) + ((a < b) ? b - a : a - b)
            );

        }


    }
}