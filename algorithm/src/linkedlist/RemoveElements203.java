package linkedlist;

/**
 * <a href="https://leetcode.cn/problems/remove-linked-list-elements/">移除链表元素</a>
 * @ClassName Main
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/27 13:09
 **/
public class RemoveElements203 {

     public class ListNode {

         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode removeElements(ListNode head, int val) {
         if (head == null) return null;
         while (head != null && head.val == val) {
             head = head.next;
         }
         ListNode prehead = head;
         while (prehead != null && prehead.next != null) {
             if (prehead.next.val == val) {
                 prehead.next = prehead.next.next;
             } else {
                 prehead = prehead.next;
             }
         }

         return head;

    }

    public static void main(String[] args) {

    }
}
