class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class GetIntersectionNode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA.next != null) {
            pA = pA.next;
        }
        while (pB.next != null) {
            pB = pB.next;
        }
        if (pA != pB) {
            return null;
        }
        pA = headA;
        pB = headB;
        while (pA != null) {
            while (pB != null && pA != pB) {
                pB = pB.next;
            }
            if (pA == pB && pB != null) {
                return pA;
            }

            pA = pA.next;
            pB = headB;
        }

        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }


}
