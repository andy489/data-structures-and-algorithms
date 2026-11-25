// https://leetcode.com/problems/custom-sort-string/

// Solution: Count and Build — O(n + m) time, O(1) space
class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (freq[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (freq[i]-- > 0) {
                sb.append((char) ('a' + i));
            }
        }
        return sb.toString();
    }
}
