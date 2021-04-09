package hacker;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;




public class T2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int orderCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> order = IntStream.range(0, orderCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.filledOrders(order, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    static class Result {

        /*
         * Complete the 'filledOrders' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY order
         *  2. INTEGER k
         */

        public static int filledOrders(List<Integer> order, int k) {
            // Write your code here
            int sum = 0;
            int count = 0;

            Iterator<Integer> iterator = order.stream().sorted().iterator();

            while (iterator.hasNext()) {
                int num = iterator.next();
                sum += num;

                if (sum > k) {
                    sum -= num;
                    break;
                } else {
                    count++;
                }
            }

            return count;

        }

    }
}
