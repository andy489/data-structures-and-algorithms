// https://leetcode.com/problems/decoded-string-at-index/

// Solution: Reverse Scan — O(n) time, O(1) space
class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                size *= (c - '0');
            } else {
                size++;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= size;
            if (k == 0 && Character.isLetter(c)) {
                return String.valueOf(c);
            }
            if (Character.isDigit(c)) {
                size /= (c - '0');
            } else {
                size--;
            }
        }
        return "";
    }
}
