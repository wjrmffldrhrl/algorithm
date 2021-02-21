package solved.P9095_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
  public static void main(String args[])throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    
    int T = Integer.parseInt(br.readLine());


    // 1 
    // 1

    // 2
    // 1 + 1
    // 2

    // 3
    // 1 + 1 + 1
    // 1 + 2
    // 2 + 1
    // 3

    // 4
    // 1 + 1 + 1 + 1
    // 1 + 1 + 2
    // 1 + 2 + 1
    // 1 + 3
    // 2 + 1 + 1
    // 2 + 2
    // 3 + 1
    
    // A(n) = A(n-1) + A(n-2) + A(n-3)

    int[] oneTwoThree = new int[10];
    oneTwoThree[0] = 1;
    oneTwoThree[1] = 2;
    oneTwoThree[2] = 4;
    for(int i = 3 ; i < 10 ; i++) {
      int tmp = 0;
      for(int j = 0 ; j < 3 ; j++) {
        tmp += oneTwoThree[i - j - 1];
      }
      oneTwoThree[i] = tmp;
    }

 



    for(int i = 0 ; i < T ; i++ ) {
        int target = Integer.parseInt(br.readLine());
        System.out.println(oneTwoThree[target - 1]);
    }
    
  }



 

}