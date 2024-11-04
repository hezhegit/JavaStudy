package stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MyStack
 * @Description TODO
 * @Author 小何
 * @Date 2024/10/13 14:02
 **/
public class MyStack {
    Queue<Integer> queue;
    Queue<Integer> help; // 辅助
    public MyStack() {
        queue = new LinkedList<Integer>();
        help = new LinkedList<>();
    }
    public void push(int x) {
        queue.add(x);
    }
    public int pop() {
        while (queue.size() > 1) {
            help.add(queue.poll());
        }
        int p = queue.poll();
        while (!help.isEmpty()) {
            queue.add(help.poll());
        }
        return p;
    }

    public int top() {
        while (queue.size() > 1) {
            help.add(queue.poll());
        }
        int p = queue.peek();
        help.add(queue.poll());
        // 交换效果可能会更好
        while (!help.isEmpty()) {
            queue.add(help.poll());
        }
        return p;
    }

    public boolean empty() {
        return queue.isEmpty();
    }



}
