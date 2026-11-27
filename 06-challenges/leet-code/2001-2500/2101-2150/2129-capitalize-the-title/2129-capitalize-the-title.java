// https://leetcode.com/problems/capitalize-the-title/
class Solution {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (w.length() <= 2) {
                sb.append(w.toLowerCase());
            } else {
                sb.append(Character.toUpperCase(w.charAt(0)));
                sb.append(w.substring(1).toLowerCase());
            }
            if (i < words.length - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
