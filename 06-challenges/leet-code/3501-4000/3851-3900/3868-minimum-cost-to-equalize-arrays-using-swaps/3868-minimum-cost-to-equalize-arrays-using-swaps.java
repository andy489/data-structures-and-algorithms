// https://leetcode.com/problems/minimum-cost-to-equalize-arrays-using-swaps/

class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        // Check if combined multiset allows equal arrays
        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : nums1) {
            freq.merge(v, 1, Integer::sum);
        }
        for (int v : nums2) {
            freq.merge(v, 1, Integer::sum);
        }
        for (int cnt : freq.values()) {
            if (cnt % 2 != 0) {
                return -1;
            }
        }
        // Sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int diff = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i]) {
                diff++;
            }
        }
        return diff / 2;
    }
}
