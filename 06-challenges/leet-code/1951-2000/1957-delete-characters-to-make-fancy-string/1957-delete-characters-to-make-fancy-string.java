// https://leetcode.com/problems/delete-characters-to-make-fancy-string/
class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int n = sb.length();
            if (n >= 2 && sb.charAt(n - 1) == c && sb.charAt(n - 2) == c) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
