import java.util.*;

public class Cycle141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                 break;
            }
        }
        if (fast != null && fast.next != null && slow == fast) {
            fast = head;
            while (fast != slow) {
//                fast = fast.next.next;
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }else {
            return null;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode l1 = list1;
        ListNode p = list1;
        ListNode l2 = list2;
        ListNode q = list2;
        while (l1 != null && l2 != null) {
            if (l1.val == l2.val) {
                p = l1.next;
                q = l2.next;
                head.next = l1;
                head = head.next;
                head.next = l2;
                head = head.next;
                l1 = p;
                l2 = q;
            }else if (l1.val > l2.val) {
                q = l2.next;
                head.next = l2;
                head = head.next;
                l2 = q;
            }else {
                p = l1.next;
                head.next = l1;
                head = head.next;
                l1 = p;
            }
        }

        if (l1 != null) {
            head.next = l1;
        }

        if (l2 != null) {
            head.next = l2;
        }

        return cur.next;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);  // 用一个哑节点简化链表操作
        ListNode current = dummyHead;  // 当前操作的节点
        int carry = 0;  // 进位

        // 同时遍历 l1 和 l2，直到两个链表都遍历完
        while (l1 != null || l2 != null || carry != 0) {
            // 获取当前节点的值，如果链表已经结束，值为 0
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // 计算当前的和以及新的进位
            int sum = x + y + carry;
            carry = sum / 10;  // 新的进位
            current.next = new ListNode(sum % 10);  // 当前节点的值为 sum % 10

            // 移动 current 指针
            current = current.next;

            // 移动 l1 和 l2 指针
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;  // 返回结果链表的头节点
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < n-1; i++) {
            right = right.next;
        }
        ListNode pre = null;
        while (right.next != null) {
            pre = left;
            left = left.next;
            right = right.next;
        }
        if (pre == null){
            return head.next;
        }
        pre.next = left.next;
        return head;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        ListNode pre = null;
        ListNode net = null;
        while (q!= null) {
            net = q.next;
            if (pre != null) {
                pre.next = q;
            }else {
                head = q;
            }
            q.next = p;
            p.next = net;
            pre = p;
            if (pre.next == null || pre.next.next == null) {
                break;
            }
            p = pre.next;
            q = p.next;
        }

        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, p = head;

        while (p != null) {
            ListNode q = p;
            // 检查是否有 k 个节点
            for (int i = 0; i < k - 1; i++) {
                q = q.next;
                if (q == null) {
                    return dummy.next; // 不足 k 个节点，返回结果
                }
            }
            ListNode n = q.next;
            reverse(p, q); // 反转当前的 k 个节点
            pre.next = q;  // 连接反转后的头节点
            p.next = n;    // 连接反转后的尾节点到剩余链表
            pre = p;
            p = n;
        }
        return dummy.next;
    }

    public static void reverse(ListNode head, ListNode tail) {
        ListNode pre = null, cur = head;
        while (cur != tail) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        tail.next = pre; // 处理 tail 节点
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    public ListNode sortList(ListNode head) {

        if (head == null) {
            return null;
        }

        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        head = list.get(0);
        ListNode pre = head;
        for (int i = 1; i < list.size(); i++) {
            pre.next = list.get(i);
            pre = pre.next;
        }
        pre.next = null;
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0 || lists[0] == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                list.add(node);
                node = node.next;
            }
        }

        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode head = list.get(0);
        ListNode pre = head;
        for (int i = 1; i < list.size(); i++) {
            pre.next = list.get(i);
            pre = pre.next;
        }
        pre.next = null;
        return head;

    }





}
