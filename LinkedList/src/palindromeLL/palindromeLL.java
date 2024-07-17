package palindromeLL;

import java.util.Stack;

public class palindromeLL {

    class Node {
        int data;
        Node next;
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isPalindromeBrute(Node head){

        if (head == null || head.next == null) return true;

        Node temp = head;

        Stack<Integer> st = new Stack<>();

        while (temp != null){
            st.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        while (temp != null){

            int cur = st.pop();

            if (temp.data != cur) return false;

            temp = temp.next;
        }

        return true;
    }

    public static boolean isPalindromeOptimal(Node head) {

        if (head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null){
            fast =fast.next.next;
            slow =slow.next;
        }

        Node newHead = reverseOptimal(slow.next);

        Node first = head, second = newHead;

        while (second != null){

            if (first.data != second.data){
                return false;
            }

            first = first.next;
            second = second.next;
        }
        slow.next = reverseOptimal(newHead);

        return true;

    }

    public static Node reverseOptimal(Node head) {

        if (head == null || head.next == null) return head;

        Node prev = null;

        Node temp = head;

        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }
}
