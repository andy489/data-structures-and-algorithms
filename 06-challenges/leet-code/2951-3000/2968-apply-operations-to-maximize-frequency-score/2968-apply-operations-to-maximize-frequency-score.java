// https://leetcode.com/problems/apply-operations-to-maximize-frequency-score/
class Solution {
    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int result = 1;
        int left = 0;
        for (int right = 0; right < n; right++) {
            while (cost(nums, prefix, left, right) > k) {
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    private long cost(int[] nums, long[] prefix, int left, int right) {
        int mid = (left + right) / 2;
        long leftCost = (long) nums[mid] * (mid - left) - (prefix[mid] - prefix[left]);
        long rightCost = (prefix[right + 1] - prefix[mid + 1]) - (long) nums[mid] * (right - mid);
        return leftCost + rightCost;
    }
}
