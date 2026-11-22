// https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/

// Solution: Substring Check — O(n) time, O(1) space
class Solution {
    public boolean checkString(String s) {
        return !s.contains("ba");
    }
}

// Solution 2: Linear Scan — O(n) time, O(1) space
class Solution2 {
    public boolean checkString(String s) {
        boolean seenB = false;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                seenB = true;
            } else if (seenB) {
                return false;
            }
        }

        return true;
    }
}
