package unsolved.P11085_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class P11085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int p = Integer.parseInt(input[0]);
        int[][] positions = new int[p][2];

        for (int i = 0; i < p; i++) {
            positions[i][0] = p;
        }

        int w = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int c = Integer.parseInt(input[0]);
        int v = Integer.parseInt(input[1]);

        for (int i = 0; i < w; i++) {
            input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int width = Integer.parseInt(input[2]);



        }
    }

    public static void connect(int[][] position, int a, int b) {

        if (find(position, a) != find(position, b)) {
            position[b][0] = a;
        }

    }

    public static int find(int[][] position, int a) {

        if (position[a][0] == a) {
            return a;
        } else {
            int c = find(position, a);
            position[a][0] = c;
            return c;
        }



    }
}
