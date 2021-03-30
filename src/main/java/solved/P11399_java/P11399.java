package solved.P11399_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] p = new int[N];
        String peopleTimes = br.readLine();

        int index = 0;
        for (String peopleTime : peopleTimes.split(" ")) {
            p[index++] = Integer.parseInt(peopleTime);
        }

        Arrays.sort(p);

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                result += p[j];
            }
        }

        System.out.println(result);



    }
}
