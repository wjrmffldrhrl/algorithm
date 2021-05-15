package unsolved.P1261_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1261 {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int brokenCount;


        public Point(int x, int y, int brokenCount) {
            this.x = x;
            this.y = y;
            this.brokenCount = brokenCount;
        }


        @Override
        public int compareTo(Point o) {
            return this.brokenCount - o.brokenCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Point> q = new PriorityQueue<>();
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        boolean[][] map = new boolean[N][M];
        int[][] isVisited = new int[N][M];

        for (int y = 0; y < N; y++) {
            int x = 0;
            for (char m : br.readLine().toCharArray()) {
                switch (m) {
                    case '0':
                        map[y][x] = true;
                        break;
                    case '1':
                        map[y][x] = false;
                }
                isVisited[y][x] = Integer.MAX_VALUE;
                x++;
            }
        }

        q.add(new Point(0, 0, 0));
        while (!q.isEmpty()) {
            Point p = q.poll();

            int x = p.x;
            int y = p.y;
            int brokenWallCount = p.brokenCount;
            isVisited[y][x] = brokenWallCount;

            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == j
                            || x + j < 0 || x + j >= map[0].length
                            || y + i < 0 || y + i >= map.length
                            || isVisited[y + i][x + j] <= brokenWallCount ) {
                        continue;
                    }

                    if (map[y + i][x + j]) {
                        q.add(new Point(x + j, y + i, brokenWallCount));
                    } else {
                        q.add(new Point(x + j, y + i, brokenWallCount + 1));
                    }


                }
            }


        }
        System.out.println(isVisited[N - 1][M - 1]);

    }


}
