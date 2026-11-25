// https://leetcode.com/problems/find-k-th-smallest-pair-distance/

// Solution: Binary Search + Sliding Window — O(n log n + n log W) time, O(1) space
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int lo = 0, hi = nums[n - 1] - nums[0];
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (countPairs(nums, mid) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int countPairs(int[] nums, int dist) {
        int count = 0, left = 0;
        for (int right = 1; right < nums.length; right++) {
            while (nums[right] - nums[left] > dist) {
                left++;
            }
            count += right - left;
        }
        return count;
    }
}
