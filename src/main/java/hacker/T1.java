package hacker;


import java.util.Scanner;
import java.util.Stack;

class Parser {
    static String isBalanced(String s) {
        Stack<Character> middleBracket = new Stack<>();
        Stack<Character> bigBracket = new Stack<>();

        char popBracket;
        for (char b : s.toCharArray()) {
            switch (b) {
                case '(':
                    middleBracket.push(b);
                    break;
                case '{':
                    bigBracket.push(b);
                    break;
                case ')':
                    if (middleBracket.isEmpty()) {
                        return "false";
                    }
                    if (middleBracket.pop() != '(') {
                        return "false";
                    }

                    break;
                case '}':
                    if (bigBracket.isEmpty()) {
                        return "false";
                    }

                    if (bigBracket.pop() != '{') {
                        return "false";
                    }


                    break;

            }
        }

        if (!middleBracket.isEmpty() || !bigBracket.isEmpty()) {
            return "false";
        } else {
            return "true";
        }

    }

}

class Solution1 {

    public static void main(String[] args) {
        Parser parser = new Parser();

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(parser.isBalanced(in.next()));
        }

        in.close();
    }
}

