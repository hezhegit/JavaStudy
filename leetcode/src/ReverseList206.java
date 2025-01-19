public class ReverseList206 {
    public ListNode reverseList(ListNode head) {
        // 需要3个辅助节点
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
