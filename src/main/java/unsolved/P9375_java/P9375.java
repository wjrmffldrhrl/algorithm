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

            String[] clothTypes = new String[n];
            for (int j = 0; j < n; j++) {
                clothTypes[j] = br.readLine().split(" ")[1];
            }


            for (int j = 2; j <= n; j++) {
                for (int k = 0; k < ; k++) {
                    
                }
            }
        }

    }
}
