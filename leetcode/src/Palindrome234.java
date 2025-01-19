import java.util.ArrayList;
import java.util.List;

public class Palindrome234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size() / 2;
        int len = list.size();
        for (int i = 0; i < n; i++) {
            if (list.get(i) != list.get(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
