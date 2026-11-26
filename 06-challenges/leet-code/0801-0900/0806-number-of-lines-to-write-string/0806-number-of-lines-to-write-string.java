// https://leetcode.com/problems/number-of-lines-to-write-string/

// Solution: Greedy Simulation — O(n) time, O(1) space
class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1, cur = 0;
        for (char c : s.toCharArray()) {
            int w = widths[c - 'a'];
            if (cur + w > 100) {
                lines++;
                cur = 0;
            }
            cur += w;
        }
        return new int[]{lines, cur};
    }
}
