package solved.P1463_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main{
  public static void main(String args[])throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    
    // 1 <= N <= 10^6
    int N = Integer.parseInt(br.readLine());
    int[] answer = new int[1000001];

    if(N == 1) {
      System.out.println("0");
      return;
    }
    
    Queue<Integer> q = new LinkedList<>();
    q.add(N);
    while(!q.isEmpty()) {

        int temp = q.poll();
        // System.out.println("temp : " + temp);
        for (int i = 0; i < 3; i++) {
            int next;
    
            if (i == 0 && (temp % 3) == 0) {
              next = temp / 3;
            } else if (i == 1 && (temp % 2) == 0) {
              next = temp / 2;
            } else if (i == 2){
              next = temp - 1;
            } else {
                continue;
            }

            // System.out.println("next : " + next);

            if(next == 1) {
                // System.out.println("temp : " + temp);
                System.out.println(answer[temp] + 1);
                return;
            }

            if(next >= 0 && answer[next] == 0) {
                q.add(next);
                answer[next] = answer[temp] + 1;
            }

        }
    }
  }

}