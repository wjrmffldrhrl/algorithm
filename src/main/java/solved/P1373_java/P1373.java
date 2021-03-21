package solved.P1373_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binary = br.readLine();
        int binaryLength = binary.length();
        int headLength = binaryLength % 3;


        for (int i = 0; i < 3 - headLength && headLength != 0; i++) {
            binary = 0 + binary;
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < binaryLength; i += 3) {
            int num = 0;

            for (int j = 0; j < 3; j++) {
                if (binary.charAt(i + j) == '1') {
                    num += Math.pow(2, (2 - j));
                }
            }
            answer.append(num);
        }

        System.out.println(answer);
    }
}
