// https://leetcode.com/problems/reducing-dishes/

// Solution: Sort + Suffix Sum Greedy — O(n log n) time, O(1) space
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int total = 0, suffixSum = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            if (suffixSum + satisfaction[i] <= 0) break;
            suffixSum += satisfaction[i];
            total += suffixSum;
        }
        return total;
    }
}
