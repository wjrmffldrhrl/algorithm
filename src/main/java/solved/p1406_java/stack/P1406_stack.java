package solved.p1406_java.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(final String args[]) throws IOException {
        String str;
        int order_num;
        final Scanner scanner = new Scanner(System.in);

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        StringBuilder result = new StringBuilder();


        final Stack<Character> f_stack = new Stack<>();
        final Stack<Character> b_stack = new Stack<>();

        

        str = br.readLine(); // 문자열 입력
 
        for(int i = 0 ; i < str.length();i++){ // 리스트에 문자열을 추가하면서 커서를 옮긴다
            f_stack.push(str.charAt(i));
        }

        order_num = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < order_num ; i++){
            StringTokenizer tk = new StringTokenizer(br.readLine()," ");
            
            String order = tk.nextToken();

            if(order.equals("P")){
                char data = tk.nextToken().charAt(0);
                f_stack.push(data);

            }
            else if(order.equals("L")){
                if(!f_stack.empty()){
                    b_stack.push(f_stack.pop());
                }
            }
            else if(order.equals("D")){
                if(!b_stack.empty()){
                    f_stack.push(b_stack.pop());
                }
            }
            else if(order.equals("B")){
                if(!f_stack.empty()){
                    f_stack.pop();
                }

            }
        }

        while(!f_stack.empty()){
            result.append(f_stack.pop());
        }

        result.reverse();
        
        while(!b_stack.empty()){
            result.append(b_stack.pop());
        }

        System.out.println(result.toString());
        scanner.close();
    }
}