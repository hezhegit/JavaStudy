package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/design-linked-list/">设计链表</a>
 * @ClassName DesignList
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/27 13:32
 **/
public class DesignList {
    List<DesignList> next;
    List<Integer> val;

    public DesignList() {
        this.next = new ArrayList<DesignList>();
        this.val = new ArrayList<>();
    }
}
