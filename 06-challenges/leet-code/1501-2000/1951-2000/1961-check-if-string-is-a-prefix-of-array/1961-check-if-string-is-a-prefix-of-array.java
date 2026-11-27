// https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/
class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            if (sb.toString().equals(s)) {
                return true;
            }
            if (sb.length() > s.length()) {
                return false;
            }
        }
        return false;
    }
}
