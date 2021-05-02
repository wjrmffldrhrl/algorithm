package unsolved.programmers;

// [카카오 인턴] 경주로 건설
public class P67259 {


    public static int solution(int[][] board) {
        boolean[][] isVisited = new boolean[board.length][board.length];
        int answer = 0;
        return answer;
    }

//    public static void find()


    /**
     * 직선 100원
     * 코너 500원
     *
     */
    public static void main(String[] args) {


        int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};


        System.out.println(solution(board));

    }

}
