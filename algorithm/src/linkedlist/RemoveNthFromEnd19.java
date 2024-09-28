package linkedlist;

/**
 * @ClassName RemoveNthFromEnd
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/28 17:04
 **/
public class RemoveNthFromEnd19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        // 找到要删除的节点
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        // 考虑 删除 head的情况，即 prev == null
        if (prev == null) {
            head = head.next;
        }else {
            prev.next = slow.next;
        }
        return head;
    }
}
