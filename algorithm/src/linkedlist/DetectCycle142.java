package linkedlist;

/**
 * @ClassName DetectCycle142
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/29 13:03
 **/
public class DetectCycle142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 存在环
            if (slow == fast) {
                //当slow和fast相遇后，将fast重置为链表的头节点head，而slow保持在相遇点。
                //然后slow和fast各自每次向前移动一步，直到它们再次相遇。
                //再次相遇的点就是环的入口。
                fast = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }

        }

        return null;
    }
}

