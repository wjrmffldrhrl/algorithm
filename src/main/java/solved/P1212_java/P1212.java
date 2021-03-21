package solved.P1212_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
  public static void main(String args[])throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    StringBuilder result = new StringBuilder();
    String n = br.readLine();


    if(n.equals("0")){
      System.out.println("0");
      return;
    }

    for(int i = 0 ; i < n.length() ; i++) {
      int target = n.charAt(i) - '0';
      String binary = Integer.toBinaryString(target);
      
      if(binary.length() == 1) {
        binary = "00" + binary;

      } else if(binary.length() == 2) {
        binary = "0" + binary;
      }

      result.append(binary);

    }

    int zeroIndex = 0;
    while(true) {
      if(result.charAt(zeroIndex) == '0') {
        zeroIndex++;
      } else {
        break;
      }
    }

    System.out.println(result.substring(zeroIndex));



    
    
  }

}