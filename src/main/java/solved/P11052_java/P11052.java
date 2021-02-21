package solved.P11052_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
  public static void main(String args[])throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    StringBuilder result = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    int[] P = new int[N];
    int[] F = new int[N];
    int inedx = 0;
    for(String str : br.readLine().split(" ")) {
        P[inedx++] = Integer.parseInt(str);
    }

    F[0] = P[0];

    for(int i = 1 ; i < N ; i++) {
        int max = P[i];

        for(int j = 0 ; j <= i - 1 ; j++) {
            int target = F[i - j - 1] + P[j];
            if(max < target) {
                max = target;
            }
        }

        F[i] = max;
    }

    System.out.println(F[N-1]);

  }

}