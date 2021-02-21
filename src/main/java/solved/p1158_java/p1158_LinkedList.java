package solved.p1158_java;

import java.util.*;

class ListNode{
    String data;
    ListNode next;

    public ListNode(){
        this.data = null;
        this.next = null;
    }

    public ListNode(String data){

        this.data = data;
        this.next = null;
    }


    public String getData(){
        return this.data;
    }
}

class CircularList{
    ListNode CL; // CL은 첫번째 노드를 가리킨다

    public CircularList(){
        this.CL = null;
    }

    void insertLastNode(String str){ // 마지막 노드에 삽입
        ListNode node = new ListNode(str); // 새로운 노드 생성

        if(CL==null){// 노드가 없을때
            CL = node;// 첫번째 노드가 새로 삽입한 노드
            node.next = node; // 노드는 자기 자신을 가리킨다
        }
        else{//노드가 있을 때
            ListNode current = CL;// 첫번째 노드의 위치를 임시 저장소에 저장
            while(current.next!=CL){//마지막 노드까지 이동
                current = current.next;
            }

            node.next = current.next;
            current.next = node;


        }
    }

    String popNode(String data){
        ListNode prev = CL;
        ListNode current = CL.next;


        while(current.data != data){
            prev = current;
            current = current.next;
        }

        //System.out.println("prev data : "+prev.getData());
        //System.out.println("currnet data : "+current.getData());

        prev.next = current.next;


        return current.getData();


    }



}
class Main{
    public static void main(String args[]){
        int N=0, K=0;
        String ans = "<";
        CircularList josephus = new CircularList();
        ListNode current = new ListNode();

        Scanner scanner = new Scanner(System.in);

        N = Integer.parseInt(scanner.next());
        K = Integer.parseInt(scanner.next());


        for(int i = 1; i < N+1 ; i++){
            
            josephus.insertLastNode(Integer.toString(i));
        }


        current = josephus.CL;      
        
        for(int j = 0 ; j < K-1; j++ ){
            current = current.next;
        }

        ans += (josephus.popNode(current.getData())+", ");

        for(int i = 0 ; i < N-1 ; i++){

            if(josephus.CL.next == josephus.CL)
                break;
            for(int j = 0 ; j < K; j++ ){
                current = current.next;
            }

            ans += (josephus.popNode(current.getData())+", ");

            
        }
        ans = ans.substring(0,ans.length()-2);

        

        System.out.print(ans+">");
        scanner.close();

    }
}