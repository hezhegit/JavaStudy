public class LengthOfLongestSubstring03 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int max = 0;
        int[] index = new int[128];
        int i = 0, j = 0;
        while (i <= j && j < s.length()) {
            if (index[s.charAt(j)] == 0) {
                index[s.charAt(j)]++;
                j++;
            }else {
                max = Math.max(max, j - i );
                index[s.charAt(i)]--;
                i++;
            }
        }

        max = Math.max(max, j - i );

        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring03 l = new LengthOfLongestSubstring03();
        System.out.println(l.lengthOfLongestSubstring(
                " "));
    }
}
