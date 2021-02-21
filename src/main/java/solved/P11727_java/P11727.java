package solved.P11727_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
  public static void main(String args[])throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    
    int n = Integer.parseInt(br.readLine());
    
    int[] F = new int[1000];
    F[0] = 1;
    F[1] = 3;

    for(int i = 2 ; i < n ; i++) {
      F[i] = (F[i - 1] + (F[i - 2]* 2) ) % 10007;
    }

    System.out.println(F[n - 1]);

    
   
  }

}