// https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/

// Solution: Greedy Stack Simulation — O(n) time, O(1) space
class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int open = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
                i++;
            } else {
                // need "))"
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i += 2;
                } else {
                    // only one ')', insert one more
                    insertions++;
                    i++;
                }
                if (open > 0) {
                    open--;
                } else {
                    // no matching '(', insert one
                    insertions++;
                }
            }
        }
        // remaining open '(' each need "))"
        insertions += open * 2;
        return insertions;
    }
}
