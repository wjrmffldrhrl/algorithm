package unsolved.P17087_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstInput = br.readLine().split(" ");
        String[] secondInput = br.readLine().split(" ");

        int N = Integer.parseInt(firstInput[0]);
        int S = Integer.parseInt(firstInput[1]);

        int[] A = new int[N + 1];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(secondInput[i]);
        }

        A[N] = S;

        Arrays.sort(A);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int num = A[i + 1] - A[i];

            if (num < min) {
                min = num;
            }
        }

        System.out.println(min);

    }
}
