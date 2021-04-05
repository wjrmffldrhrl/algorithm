package skill_check;

public class Check2 {
    public static void main(String[] args) {

        /*
            "JEROEN"	56
            "JAN"	23
         */

        String name = "JEROEN";


        System.out.println(solution(name));

    }

    private static int solution(String name) {
        String baseName = getBaseName(name.length());




        int answer = 0;


        return answer;
    }


    private static String getBaseName(int nameLength) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nameLength; i++) {
            sb.append("A");
        }

        return sb.toString();
    }
}
