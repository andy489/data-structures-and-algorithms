// https://leetcode.com/problems/intersection-of-two-arrays-ii/

// Solution 1: HashMap Frequency Count — O(n + m) time, O(min(n,m)) space
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> cloned = new HashMap<>();
        for (int n : nums1) {
            cloned.merge(n, 1, Integer::sum);
        }
        int[] result = new int[nums1.length];
        int idx = 0;
        for (int n : nums2) {
            int cnt = cloned.getOrDefault(n, 0);
            if (cnt > 0) {
                result[idx++] = n;
                cloned.put(n, cnt - 1);
            }
        }
        return java.util.Arrays.copyOf(result, idx);
    }
}

// Solution 2: Sort + Two Pointers — O(n log n + m log m) time, O(1) space
class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        java.util.Arrays.sort(nums1);
        java.util.Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result[k++] = nums1[i++];
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return java.util.Arrays.copyOf(result, k);
    }
}
