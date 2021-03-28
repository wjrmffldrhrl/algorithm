package solved.P1436_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        int N = Integer.parseInt(br.readLine());

        int number = 666;
        int index = 0;

        while (true) {
            String numberStr = String.valueOf(number);

            if (numberStr.contains("666")) {
                index++;
            }

            number++;
            if (index == N) {
                System.out.println(numberStr);
                break;
            }
        }



    }
}
