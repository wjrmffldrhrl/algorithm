package skill_check;

import java.util.LinkedList;
import java.util.Queue;

class Check1 {
    public static void main(String[] args) {

        /*
        [2, 1, 3, 2]	2	1
        [1, 1, 9, 1, 1, 1]	0	5
         */

        int[] priorities = {2, 1, 3, 2};
        int location = 2;


        System.out.println(solution(priorities, location));

    }

    private static int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        int[] priorityCounts = new int[9];

        for (int priority : priorities) {
            priorityCounts[priority - 1]++;
            q.add(priority);
        }


        int max = getMax(priorityCounts);
        int answer = 1;
        while (true) {
            int priority = q.poll();
            location--;

            if (priority < max) {
                q.add(priority);
                if (location == -1) {
                    location = q.size() - 1;
                }
            } else {
                if (location == -1) {
                    return answer;
                }
                priorityCounts[priority - 1]--;
                max = getMax(priorityCounts);
                answer++;
            }

        }

    }


    private static int getMax(int[] priorityCounts) {

        for (int i = priorityCounts.length - 1; i >= 0 ; i--) {
            int target = priorityCounts[i];
            if (target != 0) {
                return i + 1;
            }
        }

        return -1;
    }
}
