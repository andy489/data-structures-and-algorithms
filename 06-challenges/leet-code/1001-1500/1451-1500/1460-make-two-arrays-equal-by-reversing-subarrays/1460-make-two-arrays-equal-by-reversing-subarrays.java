// https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/

// Solution: Sort and Compare — O(n log n) time, O(n) space
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
