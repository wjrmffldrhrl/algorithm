package solved.P1012_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1012 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[][] moveXY = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };


    private static void testCase() throws IOException {
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int[][] farm = getFarm(N, M, K);
        boolean[][] isVisited = new boolean[N][M];


        int needsWormCount = 0;


        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (isVisited[y][x] || farm[y][x] == 0) {
                    continue;
                }

                check(farm, isVisited, x, y);
                needsWormCount++;

            }
        }

        System.out.println(needsWormCount);
    }

    public static void check(int[][] farm, boolean[][] isVisited, int x, int y) {

        isVisited[y][x] = true;

        for (int[] move : moveXY) {
            int targetX = x + move[0];
            int targetY = y + move[1];
            if (
                    targetY >= 0 && targetY < farm.length &&
                            targetX >= 0 && targetX < farm[0].length &&
                            farm[targetY][targetX] == 1 && !isVisited[targetY][targetX]
            ) {

                check(farm, isVisited, targetX, targetY);
            }
        }


    }


    private static int[][] getFarm(int rowCount, int colCount, int cabbageCount) throws IOException {

        int[][] farm = new int[rowCount][colCount];
        for (int i = 0; i < cabbageCount; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            farm[y][x] = 1;

        }

        return farm;

    }

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            testCase();
        }
    }
}
