// https://leetcode.com/problems/maximum-gap/

// Bucket sort (pigeonhole) — O(n) time, O(n) space
class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int min = nums[0], max = nums[0];
        for (int x : nums) { min = Math.min(min, x); max = Math.max(max, x); }
        if (min == max) return 0;
        int w = Math.max(1, (int) Math.ceil((double)(max - min) / (n - 1)));
        int buckets = (max - min) / w + 1;
        int[] bMin = new int[buckets], bMax = new int[buckets];
        java.util.Arrays.fill(bMin, Integer.MAX_VALUE);
        java.util.Arrays.fill(bMax, Integer.MIN_VALUE);
        for (int x : nums) {
            int i = (x - min) / w;
            bMin[i] = Math.min(bMin[i], x);
            bMax[i] = Math.max(bMax[i], x);
        }
        int gap = 0, prevMax = bMax[0];
        for (int i = 1; i < buckets; i++) {
            if (bMin[i] == Integer.MAX_VALUE) continue;
            gap = Math.max(gap, bMin[i] - prevMax);
            prevMax = bMax[i];
        }
        return gap;
    }
}
