package unsolved.P1748_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
  public static void main(String args[])throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    
    int n = Integer.parseInt(br.readLine());
    int answer = 0;
    int p = 1;
    for(int i = 1 ; i <= n ; i++ ) {
        if(i >= Math.pow(10, p)) {
            p++;
        } 

        answer += p;
        
    }


    System.out.println(answer);
  }

}