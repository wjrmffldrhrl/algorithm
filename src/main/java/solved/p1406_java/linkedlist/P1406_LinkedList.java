package solved.p1406_java.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    private final char data;

    public Node next;
    public Node prev;

    public Node() {
        this.data = ' ';
        this.next = null;
        this.prev = null;

    }

    public Node(final char input) {
        this.data = input;
        this.next = null;
        this.prev = null;

    }

    public char getData() {

        return this.data;
    }
}

class DoubleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public DoubleLinkedList() {
        final Node first_node = new Node();
        this.head = first_node;
        this.tail = first_node;
        this.size = 0;
    }

    void push(final char data) {
        final Node node = new Node(data);

        node.prev = this.tail;
        this.tail.next = node;

        this.tail = node;
        this.size++;

    }

    void P(final char input, final Node cursor) {
        final Node new_node = new Node(input); // 새로 생성된 노드

        if (cursor == this.tail) { // 커서가 마지막 노드를 가리킬때
            new_node.prev = cursor; // 새로 생성된 노드의 prev는 커서 노드
            cursor.next = new_node; // 커서 노드의 next는 새로 생성된 노드

            this.tail = new_node; // 리스트의 tail을 새로 생성된 노드로 지정
        } else {
            final Node next_node = cursor.next; // 커서 노드의 다음 노드

            new_node.prev = cursor; // 새로 생성된 노드의 prev는 커서 노드
            new_node.next = next_node; // 새로 생성된 노드의 next는 커서 노드의 다음 노드

            cursor.next = new_node; // 커서 노드의 next는 새로 생성된 노드
            next_node.prev = new_node; // 커서노드 다음노드의 prev는 새로 생성된 노드
        }

        this.size++;

    }

    Node B(final Node cursor) {
        final Node prev_node = cursor.prev;

        if (cursor == this.tail) {// 커서가 마지막 노드 tail을 가리키고 있을 때
            this.tail = prev_node;// 꼬리를 한칸 앞으로, 즉 커서가 가리키는 노드의 prev로 한다.
            this.tail.next = null; // 새로 지정된 꼬리 노드의 next를 없앤다.
        } else { // 그 외의 노드를 가리킬 때
            final Node next_node = cursor.next;
            prev_node.next = next_node;
            next_node.prev = prev_node;

        }
        this.size--;

        return prev_node;
    }

}

class Main {

    public static void main(final String args[]) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        String str;
        String order;
        int order_num;
        final Scanner scanner = new Scanner(System.in);
        Node cursor = new Node();
        int cursor_index = 0;
        final DoubleLinkedList aditor = new DoubleLinkedList();

        str = br.readLine(); // 문자열 입력
        cursor = aditor.head; // 커서를 리스트 head에

        for (int i = 0; i < str.length(); i++) { // 리스트에 문자열을 추가하면서 커서를 옮긴다
            aditor.push(str.charAt(i));
            cursor = cursor.next;
            cursor_index++;
        }

        order_num = Integer.parseInt(scanner.next());

        for (int i = 0; i < order_num; i++) {
            order = scanner.next();

            if (order.equals("P")) {
                final char data = scanner.next().charAt(0);
                aditor.P(data, cursor);
                cursor = cursor.next;
                cursor_index++;

            }
            else if(order.equals("L")){
                if(cursor_index != 0 ){
                    cursor = cursor.prev;
                    cursor_index--;
                }
            }
            else if(order.equals("D")){
                if(cursor_index != aditor.size){
                    cursor = cursor.next;
                    cursor_index++;
                }
            }
            else if(order.equals("B")){
                if(cursor_index !=0){
                    cursor = aditor.B(cursor);
                    cursor_index--;
                }

            }
            System.out.println("cursor_index : "+cursor_index);
            System.out.println("aditor size : "+aditor.size);
        }
        
        cursor = aditor.head.next;
        for(int i = 0 ; i < aditor.size;i++){ 
            sb.append(cursor.getData());
            cursor = cursor.next;
        }
        System.out.println(sb.toString());
        scanner.close();
    }
}