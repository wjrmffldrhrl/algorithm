package unsolved.programmers;

import java.util.Stack;

class Solution {
    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int answer = 0;

        for (int move : moves) {
            int doll = grab(board, move - 1);


            if (doll == 0 ) {
                continue;
            } else if (stack.peek() == -1) {
                stack.push(doll);
                continue;
            }

            int upperDoll = stack.pop();


            if (doll == upperDoll) {
                answer += 2;
            } else {
                stack.push(upperDoll);
                stack.push(doll);
            }

        }

        return answer;
    }

    public static int grab(int[][] board, int targetX) {

        for (int i = 0; i < board.length; i++) {
            if (board[i][targetX] == 0) {
                continue;
            }

            int doll = board[i][targetX];
            board[i][targetX] = 0;
            return doll;

        }

        return 0;

    }


    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));


    }
}