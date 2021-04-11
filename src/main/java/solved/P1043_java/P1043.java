package solved.P1043_java;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1043 {


    static class Party {

        int partyNumber;
        Set<Integer> members;
        List<Party> connectedParty = new ArrayList<>();

        public Party(int partyNumber, Set<Integer> members) {
            this.partyNumber = partyNumber;
            this.members = members;
        }

        public void connect(Party party) {
            connectedParty.add(party);
        }

    }

    static class SafeChecker {
        boolean isSafe = true;

        public void isNotSafe() {
            this.isSafe = false;
        }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstInput = br.readLine().split(" ");

        int N = Integer.parseInt(firstInput[0]);

        int M = Integer.parseInt(firstInput[1]);

        String[] input = br.readLine().split(" ");
        List<Integer> knowTruthMembers = new LinkedList<>();
        for (int i = 1; i <= Integer.parseInt(input[0]); i++) {
            int memberNumber = Integer.parseInt(input[i]);
            knowTruthMembers.add(memberNumber);
        }




        List<Party> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            Set<Integer> partyMembers =  new HashSet<>();
            input = br.readLine().split(" ");
            for (int j = 1; j <= Integer.parseInt(input[0]); j++) {
                int memberNumber = Integer.parseInt(input[j]);
                partyMembers.add(memberNumber);
            }

            parties.add(new Party(i, partyMembers));
        }


        for (int i = 0; i < parties.size(); i++) {
            Party targetParty = parties.get(i);

            for (int j = 0; j < parties.size(); j++) {
                if (i == j) {
                    continue;
                }
                Party party = parties.get(j);

                for (int memberNumber : targetParty.members) {
                    if (party.members.contains(memberNumber)) {
                        targetParty.connect(party);
                        break;
                    }
                }
            }
        }


        int count = 0;
        boolean[] isChecked = new boolean[parties.size()];
        for (int i = 0; i < M; i++) {
            if (isChecked[i]) {
                continue;
            }

            Party party = parties.get(i);
            SafeChecker safeChecker = new SafeChecker();
            int[] partyCount = {0};
            check(party, isChecked, knowTruthMembers, safeChecker, partyCount);

            if (safeChecker.isSafe) {
                count += partyCount[0];
            }

        }

        System.out.println(count);

//        knowTruthMembers.forEach(person -> System.out.println(" know true " + person));
//        parties.forEach(party ->{
//            System.out.println("party");
//
//            party.members.forEach(System.out::println);
//        } );

    }

    public static void check(Party party, boolean[] isChecked, List<Integer> knownTruthMembers, SafeChecker safeChecker, int[] partyCount) {
        if (isChecked[party.partyNumber]) {
            return;
        }

        isChecked[party.partyNumber] = true;
        partyCount[0]++;
        for (int member : knownTruthMembers) {
            if (party.members.contains(member)) {
                safeChecker.isNotSafe();
                break;
            }
        }

        for (Party p : party.connectedParty) {
            check(p, isChecked, knownTruthMembers, safeChecker, partyCount);
        }


    }

}
