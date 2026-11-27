// https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/

// Solution: Backtracking — O(n^2) time, O(n) space
class Solution {
    public boolean splitString(String s) {
        return backtrack(s, 0, -1, 0);
    }

    private boolean backtrack(String s, int start, long prev, int count) {
        if (start == s.length()) {
            return count >= 2;
        }
        long num = 0;
        for (int end = start; end < s.length(); end++) {
            num = num * 10 + (s.charAt(end) - '0');
            if (num > (long) 1e15) {
                break; // prevent overflow, no valid match possible
            }
            if (prev == -1 || num == prev - 1) {
                if (backtrack(s, end + 1, num, count + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
