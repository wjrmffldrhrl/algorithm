package unsolved.P9375_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());

            testCase(n, br);

        }

    }


    public static void testCase(int n, BufferedReader br) throws IOException {
        String[] clothTypes = new String[n];
        for (int j = 0; j < n; j++) {
            clothTypes[j] = br.readLine().split(" ")[1];
        }

        for (String clothType : clothTypes) {
            System.out.println(clothType);

        }
    }
}
