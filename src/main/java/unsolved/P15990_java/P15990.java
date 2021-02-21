package unsolved.P15990_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

class Main{
  public static void main(String args[])throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    
    int T = Integer.parseInt(br.readLine());

    int[] n = new int[T];
    int max = 0;
    for(int i = 0 ; i < T ; i++) {

        n[i] = Integer.parseInt(br.readLine());
        if(max < n[i])
            max = n[i];
    }
    
    
    long[] F = new long[100000];

    HashSet<String> b3 = new HashSet<>();
    HashSet<String> b2 = new HashSet<>();
    HashSet<String> b1 = new HashSet<>();


    b3.add("1");
    F[0] = 1;

    b2.add("2");
    F[1] = 1;

    b1.add("12");
    b1.add("21");
    b1.add("3");
    F[2] = 3;

    for(int i = 3 ; i < 5 ; i++) {
        HashSet<String> tmp = new HashSet<>();

        findNext(b1, tmp, "1");
        findNext(b2, tmp, "2");
        findNext(b3, tmp, "3");

        F[i] = tmp.size();

        b3 = b2;
        b2 = b1;
        b1 = tmp;
    }
    
    // for(int i = 6 ; i < max ; i++) {
    //     F[i] = F[i - 3] + F[i - 4] + F[i - 5] + (2 * F[i - 6]);
    // }

    for(int i = 5 ; i < max ; i++) {
        F[i] = (F[i - 1] - F[i - 2] + (2 * F[i - 3])  - F[i - 4] + (2 * F[i - 5])) % 1000000009;
    } 

    for(int i : n) {
        System.out.println(F[i - 1]);
    }


  }

  static void findNext(HashSet<String> b, HashSet<String> tmp, String num) {

    for(String str : b) {
        if(!str.substring(str.length() - 1).equals(num))
            tmp.add(str + num);
        if(!str.substring(0, 1).equals(num))
            tmp.add(num + str);
    }

  }

}