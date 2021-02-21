package solved.P17413_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        StringBuilder result = new StringBuilder();

        
        Stack<Character> words = new Stack<>();

        String inputs = br.readLine();
        inputs += " ";
        for(int i = 0 ; i < inputs.length();i++){
            

            if(inputs.charAt(i) == '<'){
                while(inputs.charAt(i) != '>'){
                    result.append(inputs.charAt(i++));
                }
                
                result.append(inputs.charAt(i));
            }
            else{
                while(inputs.charAt(i) != ' ' && inputs.charAt(i) != '<'){
                    words.push(inputs.charAt(i++));

                }
                while(!words.isEmpty()){
                    result.append(words.pop());
                }
                if(inputs.charAt(i) == ' ')
                    result.append(" ");
                else if(inputs.charAt(i) == '<')
                    i--;
            }
            
        }

        System.out.println(result.toString());

    }
}