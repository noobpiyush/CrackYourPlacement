package IntersectionofTwoLinkedLists;

public class IntersectionofTwoLinkedLists {

      public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1 =headA;
        ListNode d2 = headB;

        while (d1 != d2){

            d1 = d1 == null? headB: d1.next;
            d2 = d2 == null?headA:d2.next;
        }

        return d1;
    }
}
