// https://leetcode.com/problems/partition-equal-subset-sum/

// Solution: 0/1 Knapsack DP — O(n * target) time, O(target) space
class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) {
            return false;
        }
        int target = total / 2;
        boolean[] reachable = new boolean[target + 1];
        reachable[0] = true;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                reachable[j] |= reachable[j - num];
            }
        }
        return reachable[target];
    }
}
