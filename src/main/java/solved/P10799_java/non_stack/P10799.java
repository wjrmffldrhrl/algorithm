package solved.P10799_java.non_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String args[]) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
     
        
        String str = br.readLine();
        int[] laser = new int[50000];
        int stick=0;
        int set=0;
        int result=0;


        for(int i = 1; i < str.length() ; i++){ 
            
            if(str.charAt(i) == '('){ // ( 일때
                if(str.charAt(i-1) == '('){ // ((
                    stick++;
                }
                set++;
            }
            else{ // ) 일때

                if(str.charAt(i-1) == '('){ // ()
                    for(int j = 0 ; j < stick ; j++)
                        laser[j]++;
                }
                else{ // ))
                    result += (laser[stick-1]+1);
                    laser[stick-1] = 0;
                    stick--;

                }
                set--;
            }



        }
        
        System.out.println(result);

    }
}