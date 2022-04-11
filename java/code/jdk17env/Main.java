public class Main {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static boolean isPalindrome(ListNode head) {
        int count = 1;

        ListNode pt = head;
        while ((pt = pt.next)!= null) {
            count++;
        }

        ListNode reverse = null;

        pt = head;
        for (int i=0; i<count/2; i++) {
            ListNode temp = pt;
            pt = pt.next;

            temp.next = reverse;
            reverse = temp;
        }

        if ( count % 2 != 0) {
            pt = pt.next;
        }

        while (reverse != null && pt != null) {
            if (reverse.val != pt.val) {
                return false;
            }

            reverse = reverse.next;
            pt = pt.next;
        }

        return true;
    }
}