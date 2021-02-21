package solved.P2309_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Main{
    public static void main(String args[])throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        StringBuilder result = new StringBuilder();
        int[] hobits = new int[9];
        int[] answer = new int[7];
        for(int i = 0 ; i < 9 ; i++){
            hobits[i] = Integer.parseInt(br.readLine());

        }
        
        pick(answer, hobits, 0, hobits.length, 7);
        Arrays.sort(answer);
        for(int i = 0 ; i < 7 ; i++)
            System.out.println(answer[i]);

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
  
    static void pick(int[] answer, int[] numberArray, int depth, int n , int k){
        if (depth == k ){
            int sum = 0;
            for(int i = 0 ; i < k ; i++){
                sum += numberArray[i];
                 System.out.print(numberArray[i] + " ");
                
            }
            System.out.println();
            if(sum == 100){
                for(int i = 0; i < 7 ; i++){
                    answer[i] = numberArray[i]; 
                }
                
            }
                
            

            return;
        }
        
        for (int i = depth; i < n; i++) { 
            swap(numberArray, i, depth);
            pick(answer, numberArray, depth + 1, n, k); 
            swap(numberArray, i, depth); 
        }
    }
  }