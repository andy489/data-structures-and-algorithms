// https://leetcode.com/problems/maximum-and-minimum-sums-of-at-most-size-k-subarrays/

class Solution {
    public long minMaxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        // For each element, find its contribution as max and min
        // leftMax[i] = nearest index j < i with nums[j] > nums[i] (strict)
        // rightMax[i] = nearest index j > i with nums[j] >= nums[i]
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // Compute leftMax (previous greater)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            leftMax[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        // Compute rightMax (next greater or equal)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            rightMax[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        stack.clear();
        // Compute leftMin (previous less or equal)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            leftMin[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        // Compute rightMin (next less)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            rightMin[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long maxContrib = nums[i] * countSubarrays(i, leftMax[i], rightMax[i], k);
            long minContrib = nums[i] * countSubarrays(i, leftMin[i], rightMin[i], k);
            ans += maxContrib + minContrib;
        }
        return ans;
    }

    // Count subarrays containing i, within [left+1, right-1], length <= k
    private long countSubarrays(int i, int left, int right, int k) {
        // Left span: i - left (how far left we can go, capped at k)
        int leftSpan = Math.min(i - left, k);
        // Right span: right - i (how far right we can go, capped at k)
        int rightSpan = Math.min(right - i, k);
        // Count pairs (l, r) with i-l < leftSpan and r-i < rightSpan and r-l+1 <= k
        // = sum_{dl=0}^{leftSpan-1} min(rightSpan, k-dl)
        long count = 0;
        for (int dl = 0; dl < leftSpan; dl++) {
            count += Math.min(rightSpan, k - dl);
        }
        return count;
    }
}
