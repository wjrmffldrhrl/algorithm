package programmers;

// [카카오 인턴] 경주로 건설
public class P67259 {


    public static int solution(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        board[0][0] = 0;

        find(board, 0, 0, 's');



        return board[board.length - 1][board.length - 1];
    }

    public static void find(int[][] board, int x, int y, char direction) {


        if (x < board[y].length - 1 && board[y][x + 1] != 0) {
            int loadValue = direction == 'r' || direction == 's' ? board[y][x] + 100 : board[y][x] + 600;

            if (board[y][x + 1] >= loadValue) {
//                printStatus(x, y, loadValue, direction, 'r');
                board[y][x + 1] = loadValue;
                find(board, x + 1, y, 'r');
            }
        }

        if (y < board.length - 1 && board[y + 1][x] != 0) {
            int loadValue = direction == 'd' || direction == 's' ? board[y][x] + 100 : board[y][x] + 600;

            if (board[y + 1][x] >= loadValue) {
//                printStatus(x, y, loadValue, direction, 'd');
                board[y + 1][x] = loadValue;
                find(board, x, y + 1, 'd');
            }

        }

        if (y > 0 && board[y - 1][x] != 0) {
            int loadValue = direction == 'u' ? board[y][x] + 100 : board[y][x] + 600;


            if (board[y - 1][x] >= loadValue) {
//                printStatus(x, y, loadValue, direction, 'u');
                board[y - 1][x] = loadValue;
                find(board, x, y - 1, 'u');
            }
        }



        if (x > 0 && board[y][x - 1] != 0) {
            int loadValue = direction == 'l' ? board[y][x] + 100 : board[y][x] + 600;

            if (board[y][x - 1] >= loadValue) {
//                printStatus(x, y, loadValue, direction, 'l');
                board[y][x - 1] = loadValue;
                find(board, x - 1, y, 'l');
            }
        }
    }

    public static void printStatus(int x, int y, int loadValue, char direction, char to) {
        System.out.println("x " + x + " y " + y);
        System.out.println("loadValue : " + loadValue);
        System.out.println("direction : " + direction + " to " + to);

        System.out.println();
    }


    /**
     * 직선 100원R
     * 코너 500원
     *
     */
    public static void main(String[] args) {


//        int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};

//        int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
        int[][] board = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};

        System.out.println(solution(board));


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

}
