// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/

// Solution: Two Pointers Merge — O(m + n) time, O(m + n) space
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                result.add(nums1[i++]);
            } else {
                result.add(nums2[j++]);
            }
        }
        while (i < nums1.length) {
            result.add(nums1[i++]);
        }
        while (j < nums2.length) {
            result.add(nums2[j++]);
        }
        return result.toArray(new int[0][]);
    }
}
