package rev2;

import java.util.Stack;

public class rev2 {

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

    public static ListNode rev2Brute(ListNode head, int left, int right) {

        if (head == null || head.next == null) return head;

        int cnt = 1;

        Stack<Integer> st = new Stack<>();

        ListNode temp = head;

        while (temp != null) {

            if (cnt >= left && cnt <= right) {
                st.push(temp.val);
            }
            temp = temp.next;
            cnt++;
        }
        cnt = 1;
        temp = head;

        while (temp != null) {

            if (cnt >= left && cnt <= right) {
                temp.val = st.pop();
            }
            temp = temp.next;
            cnt++;
        }

        return head;
    }

    public static ListNode rev2Optimal(ListNode head, int left, int right) {

        if (head == null || head.next == null) return head;

        ListNode cur = head;
        ListNode prev = null;
        int i;
        for ( i = 1;i<left;i++){
            prev =cur;
            cur = cur.next;
        }

        ListNode rTail = cur;
        ListNode rHead = null;

        while (i<=right){

            ListNode nextNode = cur.next;
            cur.next = rHead;
            rHead =cur;
            cur = nextNode;
            i++;
        }

        if (prev != null){
            prev.next = rHead;
        }
        else {
            head = rHead;
        }

        rTail.next = cur;

        return head;
    }
}
