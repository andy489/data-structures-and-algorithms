// https://leetcode.com/problems/intersection-of-two-arrays/

// Solution: HashSet — O(n + m) time, O(n) space
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        Set<Integer> result = new HashSet<>();
        for (int n : nums2) {
            if (set1.contains(n)) {
                result.add(n);
            }
        }
        int[] arr = new int[result.size()];
        int i = 0;
        for (int n : result) {
            arr[i++] = n;
        }
        return arr;
    }
}
