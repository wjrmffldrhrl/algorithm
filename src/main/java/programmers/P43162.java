package programmers;

import java.util.HashSet;
import java.util.Set;

// solved
// https://programmers.co.kr/learn/courses/30/lessons/43162
public class P43162 {
    public int solution(int n, int[][] computers) {

        int[] parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1 ; j < n; j++) {
                if (computers[i][j] == 1) {
                    union(parents, i, j);
                }
            }
        }


        for(int i = 0 ; i < n ; i++) {
            find(parents, i);
        }


        Set<Integer> parentSet = new HashSet<>();

        for (int p : parents) {
            parentSet.add(p);
        }

        return parentSet.size();
    }

    public static int find(int[] parents, int a) {

        if (a == parents[a]) {
            return a;
        } else { // 아닐 경우 root를 찾는다
            int p = find(parents, parents[a]);

            // 해당 노드의 부모 노드를 root에 가깝게 변경
            parents[a] = p;
            return p;
        }

    }

    public static void union(int[] parents, int a, int b) {

        a = find(parents, a);
        b = find(parents, b);


        if (a != b) {
            parents[b] = a;
        }


    }

    public static void main(String[] args) {

    }
}
