package solved.P1717_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1717 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int[] n = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            n[i] = i;
        }

        int M = Integer.parseInt(input[1]);
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            if (input[0].equals("0")) {
                connect(n, a, b);

            } else {
                check(n, a, b, sb);
            }


        }

        System.out.println(sb);

    }

    public static void connect(int[] n, int a, int b) {
        a = find(n, a);
        b = find(n, b);

        if (a != b) {
            n[b] = a;
        }

    }

    public static void check(int[] n, int a, int b, StringBuilder sb) {
        if (find(n, a) == find(n, b)) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }

        sb.append("\n");
    }


    public static int find(int[] n, int a) {
        if (n[a] == a) {
            return a;
        } else {
            int p = find(n, n[a]);
            n[a] = p;
            return p;
        }
    }
}
