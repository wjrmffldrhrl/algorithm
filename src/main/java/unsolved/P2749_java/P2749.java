package unsolved.P2749_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class P2749 {


    public static int[] fibo = {1, 1, 1, 0};

    public static int[] dc(long N) {


        if (N == 1) {
            return fibo;
        }
        if (N % 2 == 0) {
            int[] a = dc(N / 2);
            int[] b = dc(N / 2);

            return mul(a, b);

        } else {
            int[] a = dc((N - 1) / 2);
            int[] b = dc((N - 1) / 2);

            return mul(mul(a, b), fibo);

        }
    }

    public static int[] mul(int[] a, int[] b) {
        return new int[]{
                (a[0] * b[0] + a[1] * b[1]) % 1000000,
                (a[0] * b[1] + a[1] * b[2]) % 1000000,
                (a[1] * b[1] + a[2] * b[2]) % 1000000
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        if (N <= 2) {
            System.out.println(1);
        } else {
            System.out.println(dc(N - 1)[0] % 1000000);
        }

    }
}
