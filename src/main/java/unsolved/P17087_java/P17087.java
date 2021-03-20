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

        if (N == 1) {
            System.out.println(Math.abs(A[0] - S));
            return;
        }

        A[N] = S;

        Arrays.sort(A);

        int[] distance = new int[N];

        for (int i = 0; i < N; i++) {
            distance[i] = A[i + 1] - A[i];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            int gcd = gcd(distance[i], distance[i + 1]);

            if (gcd < min) {
                min = gcd;

            }
        }

        System.out.println(min);
    }

    public static int gcd(int a, int b) {
        int bigger;
        int smaller;
        if (a > b) {
            bigger = a;
            smaller = b;
        } else {
            bigger = b;
            smaller = a;
        }

        int n;
        while(smaller != 0){
            n = bigger % smaller;
            bigger = smaller;
            smaller = n;
        }

        return bigger;

    }
}
