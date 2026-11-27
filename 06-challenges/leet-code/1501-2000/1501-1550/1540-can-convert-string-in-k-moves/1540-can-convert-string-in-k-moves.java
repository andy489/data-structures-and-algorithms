// https://leetcode.com/problems/can-convert-string-in-k-moves/

// Solution: Shift Frequency Count — O(n) time, O(1) space
class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int diff = (t.charAt(i) - s.charAt(i) + 26) % 26;
            if (diff != 0) {
                count[diff]++;
                if (count[diff] * 26 - 26 + diff > k) {
                    return false;
                }
            }
        }
        return true;
    }
}
