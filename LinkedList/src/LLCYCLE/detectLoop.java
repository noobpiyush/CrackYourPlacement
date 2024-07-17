package LLCYCLE;

import java.util.HashMap;
import java.util.Map;

class Node {
    // Data stored in the node
    public int data;
    // Pointer to the next node in the list
    public Node next;

    // Constructor with both data
    // and next node as parameters
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    // Constructor with only data as
    // a parameter, sets next to null
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class detectLoop {

    public static void main(String[] args) {

        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;

        // Check if there is a loop
        // in the linked list
        if (detectLoopOptimal(head)) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }

    }

    public static  boolean detectLoopBrute(Node head){

        Map<Node,Integer> map = new HashMap<>();

        Node temp = head;

        while (temp !=null){
            if (map.containsKey(temp)){
                return true;
            }

            map.put(temp,1);

            temp = temp.next;
        }

        return false;
    }

    public static boolean detectLoopOptimal(Node head) {

        Node slow = head;

        Node fast = head;

        while (fast !=null && fast.next != null){
            slow =slow.next;
            fast =fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }
}