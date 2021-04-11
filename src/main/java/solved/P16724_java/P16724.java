package solved.P16724_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Move[][] map = new Move[N][M];
        int[][] isChecked = new int[N][M];

        for (int y = 0; y < N; y++) {
            String inputRow = br.readLine();
            for (int x = 0; x < M; x++) {
                char m = inputRow.charAt(x);
                map[y][x] = new Move(m);
            }
        }


        int count = 0;
        int checkNumber = 1;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (check(map, isChecked, x, y, checkNumber)) {
                    count++;
                }
                checkNumber++;
            }
        }


        System.out.println(count);


    }

    public static boolean check(Move[][] map, int[][] isChecked, int x, int y, int checkNumber) {

        if (isChecked[y][x] == checkNumber) {
            return true;
        } else if (isChecked[y][x] != 0) {
            return false;
        }

        isChecked[y][x] = checkNumber;
        Move move = map[y][x];
        return check(map, isChecked, x + move.x, y + move.y, checkNumber);
    }

}
