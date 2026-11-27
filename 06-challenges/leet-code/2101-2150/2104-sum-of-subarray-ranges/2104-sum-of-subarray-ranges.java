// https://leetcode.com/problems/sum-of-subarray-ranges/

// Solution: Brute Force — O(n^2) time, O(1) space
class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int curMin = nums[i], curMax = nums[i];
            for (int j = i + 1; j < n; j++) {
                curMin = Math.min(curMin, nums[j]);
                curMax = Math.max(curMax, nums[j]);
                sum += curMax - curMin;
            }
        }

        return sum;
    }
}

// Solution 2: Monotonic Stack — O(n) time, O(n) space
class Solution2 {
    public long subArrayRanges(int[] nums) {
        return subarraySum(nums, true) - subarraySum(nums, false);
    }

    private long subarraySum(int[] nums, boolean findMax) {
        int n = nums.length;
        long sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() &&
                   (findMax ? nums[stack.peek()] <= nums[i] : nums[stack.peek()] >= nums[i])) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() &&
                   (findMax ? nums[stack.peek()] < nums[i] : nums[stack.peek()] > nums[i])) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            sum += (long) nums[i] * left[i] * right[i];
        }

        return sum;
    }
}
