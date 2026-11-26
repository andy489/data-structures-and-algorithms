// https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

// Solution: Quarter Candidates — O(n) time, O(1) space
// Solution: Quarter Candidates — O(n) time, O(1) space
class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length, quarter = n / 4;
        for (int i = 0; i < n - quarter; i++) {
            if (arr[i] == arr[i + quarter]) return arr[i];
        }
        return -1;
    }
}
