package RemoveDuplicatesfromSortedList;

public class Remove_Duplicates_from_Sorted_List {
    static public class ListNode {
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

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                // same
                ListNode temp = curr.next;
                curr.next = temp.next;
                temp = null;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
