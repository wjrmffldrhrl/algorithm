package solved.P2609_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int a = Integer.parseInt(input.split(" ")[0]);
        int b = Integer.parseInt(input.split(" ")[1]);

        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        System.out.println(GCD(a,b));
        System.out.println(LCM(a, b));



    }

    static int GCD(int a,int b){
        while(true){
            int r = a%b;
            if(r==0) return b;

            a = b;
            b = r;
        }
    }

    static int LCM(int a, int b)
    {
        return a * b / GCD(a,b);
    }
}
