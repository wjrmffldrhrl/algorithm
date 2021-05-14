package unsolved.P1261_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1261 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        boolean[][] map = new boolean[N][M];
        int[][] brokenWallCountToGo = new int[N][M];

        for (int y = 0; y < N; y++) {
            int x = 0;
            for (char m : br.readLine().toCharArray()) {
                brokenWallCountToGo[y][x] = Integer.MAX_VALUE;
                switch (m) {
                    case '0':
                        map[y][x] = true;
                        break;
                    case '1':
                        map[y][x] = false;
                }

                x++;
            }
        }

        move(map, 0, 0, brokenWallCountToGo, 0);

        System.out.println(brokenWallCountToGo[N - 1][M - 1]);
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(brokenWallCountToGo[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    public static void move(boolean[][] map, int x, int y, int[][] brokenWallCountToGo, int brokenWallCount) {
        if (brokenWallCountToGo[y][x] <= brokenWallCount) {
            return;
        }
        brokenWallCountToGo[y][x] = brokenWallCount;

        if (x > 0) {
            if (map[y][x - 1]) {
                move(map, x - 1, y, brokenWallCountToGo, brokenWallCount);
            } else {
                move(map, x - 1, y, brokenWallCountToGo, brokenWallCount + 1);
            }
        }
        if (y > 0) {
            if (map[y - 1][x]) {
                move(map, x, y - 1, brokenWallCountToGo, brokenWallCount);
            } else {
                move(map, x , y - 1, brokenWallCountToGo, brokenWallCount + 1);
            }
        }
        if (x < map[0].length - 1) {
            if (map[y][x + 1]) {
                move(map, x + 1, y, brokenWallCountToGo, brokenWallCount);
            } else {
                move(map, x + 1, y, brokenWallCountToGo, brokenWallCount + 1);
            }
        }
        if (y < map.length - 1) {
            if (map[y + 1][x]) {
                move(map, x, y + 1, brokenWallCountToGo, brokenWallCount);
            } else {
                move(map, x, y + 1, brokenWallCountToGo, brokenWallCount + 1);
            }
        }


    }
}
