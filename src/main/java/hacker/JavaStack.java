package hacker;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(line(input));
        }

    }

    private static boolean line(String input) {
        Stack<Character> stack = new Stack<>();
        boolean correct = true;

        forLoop:
        for (int i = 0; i < input.length(); i++) {
            char bracket = input.charAt(i);

            if (bracket == '{' || bracket == '(' || bracket == '[') {
                stack.push(bracket);
            } else {

                if (stack.size() == 0) {
                    correct = false;
                    break;
                }

                char leftBracket = stack.pop();

                switch (leftBracket) {
                    case '{':
                        if (bracket != '}') {
                            correct = false;
                            break forLoop;
                        }
                        break;
                    case '(':
                        if (bracket != ')') {
                            correct = false;
                            break forLoop;
                        }
                        break;
                    case '[':
                        if (bracket != ']') {
                            correct = false;
                            break forLoop;
                        }
                        break;
                }
            }
        }

        if (stack.size() > 0) {
            return false;
        }
        return correct;
    }
}
