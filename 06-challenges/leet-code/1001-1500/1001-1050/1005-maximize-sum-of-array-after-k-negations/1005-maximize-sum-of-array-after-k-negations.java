// https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/

// Solution: Greedy Sort — O(n log n) time, O(1) space
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Integer[] boxed = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boxed[i] = nums[i];
        }
        Arrays.sort(boxed, (a, b) -> Math.abs(b) - Math.abs(a));
        for (int i = 0; i < boxed.length; i++) {
            if (boxed[i] < 0 && k > 0) {
                boxed[i] = -boxed[i];
                k--;
            }
        }
        if (k % 2 == 1) {
            boxed[boxed.length - 1] = -boxed[boxed.length - 1];
        }
        int sum = 0;
        for (int v : boxed) {
            sum += v;
        }
        return sum;
    }
}
