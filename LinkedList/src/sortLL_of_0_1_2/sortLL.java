package sortLL_of_0_1_2;

public class sortLL {

   static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }

    public static Node segregate(Node head) {
        // add your code here

        if (head == null || head.next == null) return head;

        Node zeroHead = new Node(-1);

        Node oneHead = new Node(-1);

        Node twoHead = new Node(-1);

        Node zero = zeroHead;

        Node one  = oneHead;

        Node two = twoHead;

        Node temp = head;

        while ( temp != null ){

            if (temp.data == 0){
                zero.next = temp;
                zero = temp;;
                temp = temp.next;
            }
            else if (temp.data == 1){
                one.next = temp;
                one = temp;;
                temp = temp.next;
            }
            else {
                two.next = temp;
                two = temp;
                temp = temp.next;
            }
        }

        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;  // End the final list


        return zeroHead.next;
    }
}
