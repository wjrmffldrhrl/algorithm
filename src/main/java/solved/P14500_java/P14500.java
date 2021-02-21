package solved.P14500_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
  public static void main(String args[])throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);

    int[][] paper = new int[N][M];

    for(int i = 0 ; i < N ; i++) {
        String[] m = br.readLine().split(" ");

        for(int j = 0 ; j < M ; j++) {
            paper[i][j] = Integer.parseInt(m[j]);
        }
    }

    
    int answer = 0;
    for(int i = 0 ; i < N ; i++) {

        for(int j = 0 ; j < M ; j++) {
            
            
            // [][][][]
            if(j + 3 < M) { 
                
                int tmp = 0;

                for(int k = 0 ; k < 4 ; k++){
                    tmp += paper[i][j + k];
                }
                
                if(tmp > answer)
                    answer = tmp;
            }

            // []
            // []
            // []
            // []
            if(i + 3 < N) {
               
                int tmp = 0;

                for(int k = 0 ; k < 4 ; k++) {
                    tmp += paper[i + k][j];
                }
                

                if(tmp > answer)
                    answer = tmp;
            }


            // [0][1]
            // [2][3]
            // [4][5]
            
            if(i + 2 < N && j + 1 < M) {
                int tmp = 0;

                int[] array = new int[6];
                int arrayIndex = 0;
                for(int k = 0 ; k < 3 ; k++) {
                    for(int l = 0 ; l < 2 ; l++) {
                        array[arrayIndex] = paper[i + k][j + l];
                        tmp += paper[i + k][j + l];
                        arrayIndex++;
                    }
                }

                int index1 = 0;
                int index2 = 1;
                
                for(int k = 0 ; k < 15 ; k++) {

                    boolean flag = true;
                    if(index1 == 0 && index2 == 3) {
                        flag = false;
                    } else if(index1 == 2 && index2 == 5) {
                        flag = false;
                    } else if(index1 == 1 && index2 == 2) {
                        flag = false;;
                    } else if(index1 == 3 && index2 == 4) {
                        flag = false;;
                    } else if(index1 == 2 && index2 == 3) {
                        flag = false;;
                    }


                    if(flag) {

                        int target = (tmp - array[index1] - array[index2]);

                        if(target > answer) {
                            answer = target;
                        }
                            
                      
                    }
                    


                    index2++;

                    if(index2 > 5) {
                        
                        index1++;
                        index2 = index1 + 1;
                    }
                }


            }
            

            // [0][1][2]
            // [3][4][5]
            if(i + 1 < N && j + 2 < M) {
                int tmp = 0;
                
                int[] array = new int[6];
                int arrayIndex = 0;
                for(int k = 0 ; k < 2 ; k++) {
                    for(int l = 0 ; l < 3 ; l++) {
                        array[arrayIndex] = paper[i + k][j + l];
                        tmp += paper[i + k][j + l];
                        arrayIndex++;
                    }
                }
              

                int index1 = 0;
                int index2 = 1;
                
                for(int k = 0 ; k < 15 ; k++) {

                    boolean flag = true;
                    if(index1 == 0 && index2 == 4) {
                        flag = false;
                    } else if(index1 == 1 && index2 == 5) {
                        flag = false;
                    } else if(index1 == 1 && index2 == 3) {
                        flag = false;
                    } else if(index1 == 2 && index2 == 4) {
                        flag = false;
                    } else if(index1 == 1 && index2 == 4) {
                        flag = false;
                    }


                    if(flag) {
                        int target = (tmp - array[index1] - array[index2]);

                        if(target > answer) {
                            answer = target;
                        }
                    }
                    
                        



                    index2++;

                    if(index2 > 5) {
                        
                        index1++;
                        index2 = index1 + 1;
                    }
                }



            }


            
        }
    }

    System.out.println(answer);

  }

}