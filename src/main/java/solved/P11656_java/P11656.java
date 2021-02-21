package solved.P11656_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
  public static void main(String args[])throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    
    String S = br.readLine();

    String[] j = new String[S.length()];

    for(int i = 0 ; i < S.length() ; i++) {
        j[i] = S.substring(i);
    }

    Arrays.sort(j);

    for(String str : j) {
        System.out.println(str);
    }

    
  }

}