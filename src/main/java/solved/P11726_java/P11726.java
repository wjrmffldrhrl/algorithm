package solved.P11726_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main{
  public static void main(String args[])throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    
    int n = Integer.parseInt(br.readLine());
    long[] dp = new long[1000];

    dp[0] = 1;
    dp[1] = 2;

    for(int i = 2 ; i < n ; i++) {
      dp[i] = (dp[i - 1]  + dp[i - 2]) % 10007;
    }

    

    System.out.println(dp[n - 1]);
    
  }

}