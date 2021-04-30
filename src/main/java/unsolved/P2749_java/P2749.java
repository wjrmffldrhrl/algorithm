package unsolved.P2749_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2749 {



    public static int[] dc(long N) {

        if (N == 1) {
            return new int[]{1, 1, 0};
        }
        if (N % 2 == 0) {
            int[] a = dc(N / 2);
            int[] b = dc(N / 2);

            return mul(a, b);

        } else {
            int[] a = dc((N - 1) / 2);
            int[] b = dc((N - 1) / 2);

            return mul(mul(a, b), new int[]{1, 1, 0});

        }
    }

    public static int[] mul(int[] a, int[] b) {

        long l1 = (((long) a[0] * b[0]) + ((long) a[1] * b[1])) % 1000000;
        long l2 = (((long) a[0] * b[1])   + ((long) a[1] * b[2])) % 1000000;
        long l3 = (((long) a[1] * b[1])   + ((long) a[2] * b[2])) % 1000000;

        return new int[]{
                (int) l1,
                (int) l2,
                (int) l3
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        if (N <= 2) {
            System.out.println(1);
        } else {
            System.out.println(dc(N - 1)[0]);
        }

    }
}
