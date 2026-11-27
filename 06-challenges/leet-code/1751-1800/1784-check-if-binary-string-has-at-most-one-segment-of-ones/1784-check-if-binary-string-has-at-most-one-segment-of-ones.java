// https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/

// Solution: Check for "01" Pattern — O(n) time, O(1) space
class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
