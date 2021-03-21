package solved.P1978_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstInput = br.readLine();
        String secondInput = br.readLine();

        int N = Integer.parseInt(firstInput);
        String[] numbers = secondInput.split(" ");
        boolean[] isPrime = new boolean[1000];

        for (int i = 2; i <= 1000; i++) {
            isPrime[i - 1] = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime[i - 1] = false;
                    break;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int targetNumber = Integer.parseInt(numbers[i]);

            if (isPrime[targetNumber - 1]) {
                answer++;
            }
        }


        System.out.println(answer);
    }
}
