// https://leetcode.com/problems/minimum-size-subarray-sum/

// Solution: Sliding Window — O(n) time, O(1) space
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

// Solution 2: Binary Search on Prefix Sums — O(n log n) time, O(n) space
class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int need = prefix[i] + target;
            int lo = i + 1;
            int hi = n;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;

                if (prefix[mid] >= need) {
                    minLen = Math.min(minLen, mid - i);
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
