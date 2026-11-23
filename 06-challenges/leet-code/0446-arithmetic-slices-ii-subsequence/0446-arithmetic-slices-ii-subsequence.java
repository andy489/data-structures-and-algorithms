// https://leetcode.com/problems/arithmetic-slices-ii-subsequence/

// Solution: DP with HashMaps — O(n²) time, O(n²) space
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        HashMap<Long, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        int answer = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                int countAtJ = dp[j].getOrDefault(diff, 0);
                answer += countAtJ;
                dp[i].merge(diff, countAtJ + 1, Integer::sum);
            }
        }
        return answer;
    }
}
