package linkedlist;

/**
 * @ClassName MyLinkedList
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/27 14:24
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MyLinkedList {

    // 思考回忆：
    // 1.实现一个链表需要什么？
    // 2.头结点，当前节点，下一个节点的指针
    // 3.链表长度size来存储为尾部节点的位置，可以和head一起设置为全局变量

    int size;
    ListNode head;

    // MyLinkedList() 初始化 MyLinkedList 对象
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    // 获取链表中下标为 index 的节点的值:遍历建表
    // 你能回忆出来的：链表适合添加删除，不适合随机查找（和数组相反），链表有元素：ListNode,size,index,value这些。。。
    // 1.边界判断
    // 2.将当前节点移动到头结点的下一个节点
    // 3.遍历链表，当前节点移动到下一个节点
    // 4.链表add操作，无非就是头插，尾插，中间插入
    // 5.连表删除操作,为了简单，直接使用索引删除

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        ListNode curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        ListNode prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        ListNode prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
