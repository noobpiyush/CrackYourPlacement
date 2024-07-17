package addTWO_NOS;

public class addTwoNo {

    static class Node{
        int data;
        Node next;

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

    }

    public static Node add(Node l1, Node l2){

        Node dummy = new Node(-1);

        Node h1 = l1, h2 = l2;
        Node temp = dummy;

        int carry = 0;
        while (h1 != null || h2 != null || carry == 1){
            int sum = 0;
            if (h1 != null){
                sum += h1.data;
                h1 = h1.next;
            }

            if (h2 != null){
                sum += h2.data;
                h2 =h2.next;
            }

            sum += carry;
            carry = sum/10;

            Node newNode = new Node(sum%10);

            temp.next= newNode;
            temp = temp.next;
        }
        return dummy.next;
    }
}

