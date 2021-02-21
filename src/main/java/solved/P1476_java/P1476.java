package solved.P1476_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
  public static void main(String args[])throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    
    String[] ESM = br.readLine().split(" ");
    int year = 1;

    // (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
    int E = Integer.parseInt(ESM[0]);
    int S = Integer.parseInt(ESM[1]);
    int M = Integer.parseInt(ESM[2]);


    while(true) {
        if( S == 1 && M == 1 && E == 1)
            break;

        E--;
        S--;
        M--;

        if(E == 0)
            E = 15;
        if(S == 0)
            S = 28;
        if(M == 0)
            M = 19;

        year++;

    }
    
    System.out.println(year);

  }

}