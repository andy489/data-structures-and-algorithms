// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/

// Solution: Greedy Group Sum — O(n) time, O(1) space
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int total = 0;
        int i = 0, n = colors.length();
        while (i < n) {
            int j = i;
            int groupSum = 0, groupMax = 0;
            while (j < n && colors.charAt(j) == colors.charAt(i)) {
                groupSum += neededTime[j];
                groupMax = Math.max(groupMax, neededTime[j]);
                j++;
            }
            total += groupSum - groupMax;
            i = j;
        }
        return total;
    }
}
