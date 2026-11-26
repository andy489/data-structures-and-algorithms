// https://leetcode.com/problems/4sum-ii/

// Solution: HashMap — O(n²) time, O(n²) space
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> pairSums = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                pairSums.merge(a + b, 1, Integer::sum);
            }
        }
        int count = 0;
        for (int c : nums3) {
            for (int d : nums4) {
                count += pairSums.getOrDefault(-(c + d), 0);
            }
        }
        return count;
    }
}
