### 滑动窗口

滑动窗口是双指针算法的一种，基本思路为维护一个窗口，然后从前往后遍历元素进行运算。

双指针算法常见的为三种：
- 快慢指针算法（常用于链表有环判断）
- 双向指针（两个指针一个从最左，一个从最右出发进行查找），典型应用为二分查找
- 滑动窗口（两个指针一前一后出发，两个指针中间维持一个窗口结构

基本思路

（1）初始化窗口:
初始化左右边界 left = right = 0，把索引闭区间 [left, right] 称为一个「窗口」。

（2）寻找可行解：
我们先不断地增加 right 指针扩大窗口 [left, right]，直到窗口中的满足可行解。

（3）优化可行解：
此时，我们停止增加 right，转而不断增加 left 指针缩小窗口 [left, right]，直到窗口中的可行解不再符合要求。同时，每次增加 left，我们都要更新一轮结果。

（4）滑动窗口，直至一次遍历结束：
重复第 2 和第 3 步，直到 right 到达到的尽头。

```java
public void slideWindowTemplate(String nums){
    int l = 0, r = 0;        //[初始化窗口]
    //codes...               [其他初始化信息,定义一些维护数据的数据结构]
    while(r < nums.length){ //右边框移动
        r++;                 //[增大窗口]
        //codes.....         [更新窗口中的数据] 
        while(l < r && check(xxx) == false){   //[窗口不满足某种性质]
              l++;             //[缩小窗口]
            //codes...       [维护窗口中的数据]
        }
    }
}
```

滑动窗口算法是一种在字符串或数组中寻找特定模式的高效算法。它的核心思想是通过维护一个“窗口”，这个窗口内的数据满足某种条件，然后通过移动这个窗口来遍历整个字符串或数组，寻找满足条件的子串或子数组。

滑动窗口算法通常用于解决以下两类问题：

- 寻找子串/子数组：在一个大的字符串或数组中寻找满足特定条件的最短或最长的连续子串或子数组。
- 计数问题：计算某个字符串或数组中满足特定条件的子串或子数组的数量。

算法步骤

- 初始化：定义两个指针，通常称为start和end，分别表示窗口的开始和结束位置。窗口的初始大小为0。

- 扩展窗口：移动end指针（向右移动），将更多的元素包含进窗口中，直到窗口内的元素满足某种特定的条件。

- 收缩窗口：一旦窗口满足条件，尝试通过移动start指针（向左移动）来缩小窗口的大小，以找到满足条件的最小或最大窗口。

- 记录结果：在每次窗口满足条件时，记录当前窗口的大小或位置，并更新全局的最小或最大值。

- 重复：继续移动end指针，重复上述过程，直到end指针到达字符串或数组的末尾。

- 返回结果：遍历完成后，返回记录的最小或最大窗口。

应用示例
- 字符串匹配问题：比如寻找字符串s中最短的包含字符串t所有字符的子串。

- 初始化：创建两个哈希表，一个用于存储t中字符的出现次数，另一个用于存储当前窗口中字符的出现次数。

- 扩展窗口：遍历s，使用end指针将字符添加到窗口中，直到窗口包含了t中的所有字符。

- 收缩窗口：当窗口满足条件后，移动start指针，尝试缩小窗口，同时更新满足条件的最小窗口。

- 记录结果：记录满足条件的最小窗口的起始位置和长度。

- 返回结果：遍历结束后，返回最小的满足条件的子串。

```java
public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int start = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        int validCount = tMap.size();

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && windowMap.get(c).intValue() <= tMap.get(c)) {
                validCount--;
            }

            while (validCount == 0) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                char startChar = s.charAt(start++);
                windowMap.put(startChar, windowMap.get(startChar) - 1);

                if (tMap.containsKey(startChar) && windowMap.get(startChar).intValue() < tMap.get(startChar)) {
                    validCount++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
```

