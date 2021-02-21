package solved.p3085_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        char[][] candies = new char[N][N];

        for (int i = 0; i < N; i++) {
            String inputLine = br.readLine();
            for (int j = 0; j < N; j++) {
                candies[i][j] = inputLine.charAt(j);
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                char[][] tmp = swap(candies, j, i, j - 1, i);
                
                int howMany = canEatCandy(tmp, N);
                // System.out.println(tmp[0][0]);
                if(answer < howMany)
                    answer = howMany;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char[][] tmp = swap(candies, j, i, j, i - 1);
                int howMany = canEatCandy(tmp, N);
                
                if(answer < howMany)
                    answer = howMany;
            }

        }

        System.out.println(answer);


    }

    static char[][] swap(char[][] origin, int x1, int y1, int x2, int y2) {

        char tmp;
        char[][] candies = new char[origin.length][origin[0].length];

        for(int i = 0 ; i < origin.length ; i++) {            
            for(int j = 0 ; j < origin[i].length ; j++) {
                candies[i][j] = origin[i][j];

            }
        }

        tmp = candies[y1][x1];
        candies[y1][x1] = candies[y2][x2];
        candies[y2][x2] = tmp;

        return candies;
    }

    static int canEatCandy(char[][] candies, int N) {
        int howMany = 0;

        for (int i = 0; i < N; i++) {
            int tmp = 1;
            for (char cs : candies[i]) {

            }

            for (int j = 1; j < N; j++) {

                if (candies[i][j - 1] == candies[i][j]) {
                    tmp++;

                } else {

                    tmp = 1;
                }
                if (tmp > howMany)
                    howMany = tmp;
            }

        }

        for (int i = 0; i < N; i++) {
            int tmp = 1;
            for (int j = 1; j < N; j++) {
                if (candies[j - 1][i] == candies[j][i]) {
                    tmp++;
                } else {
                    
                    tmp = 1;
                }
                if (tmp > howMany)
                    howMany = tmp;
            }
        }

        return howMany;
    }
}