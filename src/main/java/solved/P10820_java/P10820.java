package solved.P10820_java;

import java.io.*;
import java.util.StringTokenizer;


class Main {
    public static void main(String args[]) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
 

        String str = "";
        while((str = br.readLine()) != null && str.length() != 0){

            StringBuilder sb = new StringBuilder();
            int small=0, big=0, num=0, blank=0;


            for(int i = 0 ; i < str.length() ; i++){
                char target = str.charAt(i);
                
                if(target == ' ')
                    blank++;
                else if(target >= '0' && target <= '9')
                    num++;
                else if(target >= 'A' && target <= 'Z')
                    big++;
                else if(target >= 'a' && target <= 'z')
                    small++;
            }
            System.out.println(small + " " + big + " " + num + " " + blank);
        }


    }
}