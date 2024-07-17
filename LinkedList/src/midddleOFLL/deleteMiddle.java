package midddleOFLL;

public class deleteMiddle {

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

    public static Node deleteBrute(Node head) {

        if (head == null || head.next == null) return head;

        Node temp = head;

        int cnt = 0;

        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        int middleNode = (cnt / 2);

        temp = head;

        while (temp != null) {
            middleNode--;
            if (middleNode == 0) {
                Node midlle = temp.next;

                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return head;
    }

    public static Node deleteOptimal(Node head) {

        Node fast = head;

        Node slow = head;

        fast =fast.next.next;

        while (fast != null && fast.next != null){
            slow =slow.next;
            fast =fast.next.next;
        }

        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return head;
    }
}

