package unsolved.P1162_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P1162 {
    static class City implements Comparable<City>{
        int number;
        int distance;

        public City(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }

        @Override
        public int compareTo(City city) {
            return this.distance - city.distance;
        }
    }


    public static void dfs(List<List<City>> cities, List<City> load, int cityNumber) {



    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<City> heap = new PriorityQueue<>();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        List<List<City>> cities = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            cities.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);


            cities.get(a).add(new City(b, d));
            cities.get(b).add(new City(a, d));
        }







    }
}
