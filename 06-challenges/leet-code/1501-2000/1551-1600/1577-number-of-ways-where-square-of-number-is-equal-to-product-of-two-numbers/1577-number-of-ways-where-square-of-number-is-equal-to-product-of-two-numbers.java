// https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/

// Solution: HashMap Count — O(m + n) time, O(m + n) space
class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        return countTriplets(nums1, nums2) + countTriplets(nums2, nums1);
    }

    private int countTriplets(int[] a, int[] b) {
        java.util.Map<Long, Long> freq = new java.util.HashMap<>();
        for (int x : b) {
            freq.merge((long) x, 1L, Long::sum);
        }
        int count = 0;
        for (int x : a) {
            long sq = (long) x * x;
            for (java.util.Map.Entry<Long, Long> e : freq.entrySet()) {
                long bVal = e.getKey();
                if (sq % bVal == 0) {
                    long pair = sq / bVal;
                    if (pair != bVal) {
                        count += e.getValue() * freq.getOrDefault(pair, 0L);
                    } else {
                        long v = e.getValue();
                        count += v * (v - 1);
                    }
                }
            }
        }
        return count / 2;
    }
}
