// https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/

// Solution: Greedy with Gain Counts — O(n + m) time, O(1) space
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;
        for (int x : nums1) sum1 += x;
        for (int x : nums2) sum2 += x;
        if (sum1 == sum2) return 0;
        // Make sure sum1 > sum2: we want to decrease sum1 or increase sum2
        if (sum1 < sum2) {
            int[] tmp = nums1; nums1 = nums2; nums2 = tmp;
            int t = sum1; sum1 = sum2; sum2 = t;
        }
        int diff = sum1 - sum2;
        // Check impossible
        if (nums1.length * 1 > nums2.length * 6) return -1; // already handled
        // gains[g] = how many elements can reduce diff by g (1..5)
        int[] gains = new int[6];
        for (int x : nums1) gains[x - 1]++; // can reduce by x-1 (change to 1)
        for (int x : nums2) gains[6 - x]++; // can increase by 6-x (change to 6)
        int ops = 0;
        for (int g = 5; g >= 1 && diff > 0; g--) {
            int use = Math.min(gains[g], (diff + g - 1) / g);
            ops += use;
            diff -= use * g;
        }
        return diff <= 0 ? ops : -1;
    }
}
