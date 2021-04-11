package unsolved.P16724_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16724 {
    static class Move {
        int x;
        int y;

        public Move(char command) {
            switch (command) {
                case 'U':
                    x = 0;
                    y = -1;
                    break;
                case 'D':
                    x = 0;
                    y = 1;
                    break;
                case 'L':
                    x = -1;
                    y = 0;
                    break;
                case 'R':
                    x = 1;
                    y = 0;
                    break;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Move[][] map = new Move[N][M];
        // 완벽하게 체크된 위치
        Set<Move> isChecked = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String inputRow = br.readLine();
            for (int j = 0; j < M; j++) {
                char m = inputRow.charAt(j);
                map[i][j] = new Move(m);
            }
        }


        int count = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (isChecked.contains(map[y][x])) {
                    continue;
                }

                // 이번에 방문 위치
                Set<Move> isVisited = new HashSet<>();
                if (isNeedSafeZone(map, isChecked, isVisited, x, y)) {
                    count++;
                }

                isChecked.addAll(isVisited);

            }
        }

        System.out.println(count);


    }

    public static boolean isNeedSafeZone(Move[][] map, Set<Move> isChecked, Set<Move> isVisited, int startX, int startY) {
        if (isChecked.contains(map[startY][startX])) {
            return false;
        }

        if (isVisited.contains(map[startY][startX])) {
            return true;
        }

        isVisited.add(map[startY][startX]);

        Move move = map[startY][startX];
        return isNeedSafeZone(map, isChecked, isVisited, startX + move.x, startY + move.y);
    }

    public static void updateChecked(boolean[][] isChecked, boolean[][] isVisited) {
        for (int i = 0; i < isChecked.length; i++) {
            for (int j = 0; j < isChecked[i].length; j++) {
                if (isVisited[i][j]) {
                    isChecked[i][j] = true;
                }
            }
        }
    }
}
