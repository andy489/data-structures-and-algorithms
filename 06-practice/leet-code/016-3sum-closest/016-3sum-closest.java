// https://leetcode.com/problems/3sum-closest/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        final int n = nums.length;

        for (int i = 0; i < n - 2; ++i) {
            int l = 0;
            int r = n - 1;

            while (l < r) {
                if (l == i) {
                    ++l;
                    continue;
                }

                if (r == i) {
                    --r;
                    continue;
                }

                int curSum = nums[i] + nums[l] + nums[r];

                if (curSum == target) {
                    return curSum;
                }

                if (Math.abs(curSum - target) < Math.abs(closestSum - target)) {
                    closestSum = curSum;
                }

                if (curSum < target) {
                    ++l;
                } else {
                    --r;
                }
            }
        }
        return closestSum;
    }
}