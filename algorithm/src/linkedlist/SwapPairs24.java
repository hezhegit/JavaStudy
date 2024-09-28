package linkedlist;

/**
 * <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/">交换相邻的节点</a>
 * @ClassName SwapPairs
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/28 16:39
 **/
public class SwapPairs24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head; // 当前节点
        ListNode pair = null;// 相邻的点
        ListNode prev = null;
        head = head.next;
        while (curr!= null && curr.next != null) {
            pair = curr.next;
            ListNode nextTemp = pair.next;
            pair.next = curr;
            curr.next = nextTemp;
            curr = nextTemp;
            if (prev != null) {
                prev.next = pair;
                prev = pair.next;
            }else {
                prev = pair.next;
            }
        }
        return head;
    }
}
