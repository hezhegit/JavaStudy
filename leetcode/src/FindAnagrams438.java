import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindAnagrams438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();

        Arrays.sort(ps);

        for (int i = 0; i <= ss.length - ps.length; i++){
            char[] temp = s.substring(i, i + ps.length).toCharArray();
            Arrays.sort(temp);
            if (Arrays.equals(ps, temp)){
                ans.add(i);
            }
        }


        return ans;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (char c : p.toCharArray()) {
            c1[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            c2[s.charAt(i) - 'a']++;

            // 移除窗口外的元素
            if (i >= p.length()) {
                c2[s.charAt(i-p.length()) - 'a']--;
            }

            if (Arrays.equals(c1, c2)) {
                ans.add(i-p.length()+1);
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> ans = new FindAnagrams438().findAnagrams2(s, p);
        System.out.println(ans);
//        System.out.println(s.substring(0, 2));
    }

}
