package programmers;


// https://programmers.co.kr/learn/courses/30/lessons/12979  기지국 설치
// solved
public class P12979 {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;

        int beforeEnd = -1;
        int bandWidth = w * 2 + 1;
        for (int station : stations) {
            station--;

            int start = station - w;


            if (start < 0) {
                start = 0;
            }

            int end = station + w;

            if (beforeEnd >= start - 1) {
                beforeEnd = end;
                continue;
            }

            int unReachableLength = start - beforeEnd - 1;


            answer += unReachableLength / bandWidth;

            if (unReachableLength % bandWidth > 0) {
                answer++;
            }

            beforeEnd = end;

        }

        if (beforeEnd > n - 1) {
            beforeEnd = n - 1;
        }

        int unReachableLength = n - 1 - beforeEnd;
        answer += unReachableLength / bandWidth;

        if (unReachableLength % bandWidth > 0) {
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 11;
        int[] stations = {4, 5, 11};
        int w = 1;

        System.out.println(solution(n, stations, w));
    }
}
