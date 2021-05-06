package unsolved.P1052_java;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Stack<Integer> firstStack = new Stack<>();
        Stack<Integer> secondStack = new Stack<>();

        int l = 1;
        while (N > 1) {

            if (N % 2 != 0) {
                N--;
                firstStack.add(l);

            }

            N /= 2;
            l *= 2;
        }

        firstStack.add(l);

        while (!firstStack.isEmpty()) {
            secondStack.push(firstStack.pop());
        }


        int buyCount = 0;
        while (secondStack.size() > K) {
            int bottle1 = secondStack.pop();
            int bottle2 = secondStack.pop();

            if (bottle1 == bottle2) {
                secondStack.push(bottle1 + bottle2);
            } else {
                secondStack.push(bottle2);

                buyCount += bottle1;
                bottle1 *= 2;
                secondStack.push(bottle1);
            }

        }

        System.out.println(buyCount);

    }

}
