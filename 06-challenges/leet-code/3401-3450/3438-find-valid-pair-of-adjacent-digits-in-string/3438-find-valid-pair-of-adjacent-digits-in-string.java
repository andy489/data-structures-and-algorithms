// https://leetcode.com/problems/find-valid-pair-of-adjacent-digits-in-string/
class Solution {
    public String findValidPair(String s) {
        int[] freq = new int[10];
        for (char c : s.toCharArray()) {
            freq[c - '0']++;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            int a = s.charAt(i) - '0';
            int b = s.charAt(i + 1) - '0';
            if (a != b && freq[a] == a && freq[b] == b) {
                return "" + s.charAt(i) + s.charAt(i + 1);
            }
        }
        return "";
    }
}
