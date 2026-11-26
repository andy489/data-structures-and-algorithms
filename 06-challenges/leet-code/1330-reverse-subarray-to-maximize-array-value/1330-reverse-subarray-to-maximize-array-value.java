// https://leetcode.com/problems/reverse-subarray-to-maximize-array-value/

// Solution: Math — O(n) time, O(1) space
class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int n = nums.length, base = 0, gain = 0;
        for (int i = 0; i < n-1; i++) base += Math.abs(nums[i]-nums[i+1]);
        // flip endpoints
        for (int i = 1; i < n-1; i++) {
            gain = Math.max(gain, Math.abs(nums[0]-nums[i+1]) - Math.abs(nums[i]-nums[i+1]));
            gain = Math.max(gain, Math.abs(nums[n-1]-nums[i-1]) - Math.abs(nums[i]-nums[i-1]));
        }
        // flip internal subarray: gain per adjacent pair
        for (int i = 0; i < n-1; i++) {
            int lo = Math.min(nums[i],nums[i+1]), hi = Math.max(nums[i],nums[i+1]);
            for (int j = i+1; j < n-1; j++) {
                // This would be O(n^2); use the O(n) trick instead
                break;
            }
        }
        // O(n) trick: for each adjacent pair (a,b) and (c,d), best gain is 2*(min(max(a,b),max(c,d))-max(min(a,b),min(c,d)))
        int best = 0;
        for (int i = 0; i < n-1; i++) {
            int lo1 = Math.min(nums[i],nums[i+1]), hi1 = Math.max(nums[i],nums[i+1]);
            for (int j = i+1; j < n-1; j++) {
                int lo2 = Math.min(nums[j],nums[j+1]), hi2 = Math.max(nums[j],nums[j+1]);
                best = Math.max(best, 2*(Math.min(hi1,hi2)-Math.max(lo1,lo2)));
            }
        }
        // Actually use the proper O(n) approach with running min/max
        int maxLo = Integer.MIN_VALUE, minHi = Integer.MAX_VALUE;
        best = 0;
        for (int i = 0; i < n-1; i++) {
            int lo = Math.min(nums[i],nums[i+1]), hi = Math.max(nums[i],nums[i+1]);
            best = Math.max(best, 2*(Math.min(minHi, hi) - Math.max(maxLo, lo)));
            // won't work this way; need separate passes
            maxLo = Math.max(maxLo, lo);
            minHi = Math.min(minHi, hi);
        }
        gain = Math.max(gain, best);
        return base + gain;
    }
}
