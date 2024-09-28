package linkedlist;

/**
 * @ClassName ReverseList
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/28 16:07
 **/
public class ReverseList206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null; // 保存前一个节点
        ListNode curr = head; // 当前节点
        while (curr != null) {
            ListNode temp = curr.next; // 临时节点
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ReverseList206 reverseList = new ReverseList206();
        System.out.println(reverseList.reverseList(head));
    }
}
