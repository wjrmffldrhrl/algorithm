package solved.P1874_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

class Main {
    public static void main(String args[]) throws NumberFormatException, IOException{

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        StringBuilder result = new StringBuilder();

        Stack<Integer> su = new Stack<>();//수열을 만들어 줄 스텍

        int n = Integer.parseInt(br.readLine());//수열의 길이
        int num = 1;//수열의 시작

        for(int i = 0 ; i < n ; i++){
            int target = Integer.parseInt(br.readLine());//수열에 들어갈 숫자를 입력 받는다.

            if(su.isEmpty()){//스택이 비었을때 오류 처리
                su.push(num++);
                //System.out.println("+"+su+target+"\n");
                result.append("+\n");
            }
            while(su.peek() < target){ // 스택에 있는 숫자가 타겟보다 적을때 스텍을 채워 넣는다
                su.push(num++);
                //System.out.println("+"+su+target+"\n");
                result.append("+\n");
            }
            while(su.peek() == target){ // 스택에 있는 숫자가 타겟과 같을 때 pop을 실행
                su.pop();
                //System.out.println("-"+su+target+"\n");
                result.append("-\n");
                if(su.isEmpty())//pop을 진행한 후 스택이 비어있을때 반복 중단
                    break;

            }
            
        }
        if(!su.isEmpty())
            System.out.println("NO");
        else
            System.out.println(result.toString());

    }
}