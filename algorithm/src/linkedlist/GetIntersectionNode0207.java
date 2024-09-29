package linkedlist;

/**
 * @ClassName GetIntersectionNode0207
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/29 12:54
 **/
public class GetIntersectionNode0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while (p != null ) {
            while (q != null){
                if (q == p){
                    return p;
                }else {
                    q = q.next;
                }
            }
            q = headB;
            p = p.next;
        }
        return p;
    }
}
