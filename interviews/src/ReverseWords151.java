public class ReverseWords151 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] sp = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = sp.length - 1; i >= 0; i--) {
            if (sp[i].trim().equals("")) {
                continue;
            }
            sb.append(sp[i].trim()+ " ");
        }
        return sb.toString().trim();
    }

}
