// https://leetcode.com/problems/type-of-triangle/

// Solution: Case Analysis — O(1) time, O(1) space
class Solution {
    public String triangleType(int[] nums) {
        java.util.Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) { return "none"; }
        if (nums[0] == nums[2]) { return "equilateral"; }
        if (nums[0] == nums[1] || nums[1] == nums[2]) { return "isosceles"; }
        return "scalene";
    }
}
