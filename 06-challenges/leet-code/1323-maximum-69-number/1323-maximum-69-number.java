// https://leetcode.com/problems/maximum-69-number/

// Solution: String replace first — O(log n) time, O(1) space
class Solution {
    public int maximum69Number(int num) {
        return Integer.parseInt(Integer.toString(num).replaceFirst("6", "9"));
    }
}
