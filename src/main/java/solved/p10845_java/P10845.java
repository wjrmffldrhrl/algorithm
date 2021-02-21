package solved.p10845_java;

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


class Queue{
    ListNode front;
    ListNode back;
    int size;

    public Queue(){
        this.front = null;
        this.back = null;
    }

    void push(String data){
        ListNode node = new ListNode(data);

        if(this.front == null){
            this.front = node;
            this.back = node;

        }
        else{
            this.back.next = node;
            this.back = node;
        }
        this.size++;
        
    }

    String pop(){
        String data;

        if(this.front == null){
            return "-1";
        }
        else{
            data = this.front.getData();

            this.front = this.front.next;
            this.size--;
            return data;
        }

    }

    String getSize(){
        return Integer.toString(this.size);
    }
    String empty(){
        if(this.front == null)
            return "1";
        else
            return "0";
    }

    String getFront(){
        if(this.front == null){
            return "-1";
        }
        else{
            return front.getData();
        }
    }
    String getBack(){
        if(this.front == null){
            return "-1";
        }
        else{
            return back.getData();
        }
    }


}

class Main{
    public static void main(String args[]){
        Queue p = new Queue();
        int n=0;
        String order="";
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.next());

        for(int i = 0 ; i < n ; i++){
            order = scanner.next();

            if(order.equals("push")){
                String data;
                data = scanner.next();

                p.push(data);

            }
            else if(order.equals("pop")){
                System.out.println(p.pop());
            }
            else if(order.equals("size")){
                System.out.println(p.getSize());
            }
            else if(order.equals("empty")){
                System.out.println(p.empty());
            }
            else if(order.equals("front")){
                System.out.println(p.getFront());
            }
            else if(order.equals("back")){
                System.out.println(p.getBack());
            }

        }
       

    }
}