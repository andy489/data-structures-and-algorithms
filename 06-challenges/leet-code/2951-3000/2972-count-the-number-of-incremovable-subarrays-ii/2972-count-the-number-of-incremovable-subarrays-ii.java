// https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-ii/
class Solution {
    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int prefixEnd = 0;
        while (prefixEnd + 1 < n && nums[prefixEnd] < nums[prefixEnd + 1]) {
            prefixEnd++;
        }
        if (prefixEnd == n - 1) {
            return (long) n * (n + 1) / 2;
        }
        long count = n - prefixEnd;
        int j = n - 1;
        for (int i = prefixEnd; i >= 0; i--) {
            while (j > i && nums[j] <= (i > 0 ? nums[i - 1] : 0)) {
                j++;
                if (j >= n) {
                    break;
                }
            }
            while (j < n && (i == 0 || nums[i - 1] < nums[j])) {
                j--;
            }
            count += n - (j + 1);
            if (i > 0 && nums[i - 1] >= nums[i]) {
                break;
            }
        }
        return count;
    }
}
