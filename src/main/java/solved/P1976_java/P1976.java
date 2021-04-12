package solved.P1976_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1976 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] cities = new int[N];
        int[] targetCities = new int[M];
        for (int i = 0; i < N; i++) {
            cities[i] = i;
        }


        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (input[j].equals("1")) {
                    connectCity(cities, cities[j], cities[i]);
                }
            }
        }

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            targetCities[i] = Integer.parseInt(input[i]) - 1;
        }

        int connectNumber = cities[targetCities[0]];
        for (int targetCity : targetCities) {
            if (connectNumber != cities[targetCity]) {
                System.out.printf("NO");
                return;
            }
        }

        System.out.printf("YES");

    }

    private static void connectCity(int[] city, int target , int to) {
        for (int k = 0; k < city.length; k++) {
            if (city[k] == target) {
                city[k] = to;
            }
        }
    }

}
