package hashtable;

/**
 * @ClassName Anagram204
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/30 20:45
 **/
public class Anagram242 {
    //暴力
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }

        return true;
    }
}

