package unsolved.P1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if (K == 1) {
            System.out.println(1);
        } else if (K == N * N) {
            System.out.println(N * N);
        }




    }
}
