// https://leetcode.com/problems/minimize-length-of-array-using-operations/

// Solution: Min Element Analysis — O(n) time, O(1) space
class Solution {
    public int minimumArrayLength(int[] nums) {
        int mn = Integer.MAX_VALUE;
        for (int x : nums) { mn = Math.min(mn, x); }
        int nonMult = 0;
        for (int x : nums) { if (x % mn != 0) { nonMult++; } }
        return nonMult + 1;
    }
}
