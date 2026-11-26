// https://leetcode.com/problems/ant-on-the-boundary/

// Solution: Prefix Sum — O(n) time, O(1) space
class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int pos = 0, count = 0;
        for (int x : nums) {
            pos += x;
            if (pos == 0) { count++; }
        }
        return count;
    }
}
