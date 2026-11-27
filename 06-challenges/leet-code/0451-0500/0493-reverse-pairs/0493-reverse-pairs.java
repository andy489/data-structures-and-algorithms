// https://leetcode.com/problems/reverse-pairs/

// Solution: Modified Merge Sort — O(n log n) time, O(n) space
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        // Count reverse pairs before merging
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        // Standard merge
        int[] temp = new int[right - left + 1];
        int p1 = left, p2 = mid + 1, idx = 0;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                temp[idx++] = nums[p1++];
            } else {
                temp[idx++] = nums[p2++];
            }
        }
        while (p1 <= mid) {
            temp[idx++] = nums[p1++];
        }
        while (p2 <= right) {
            temp[idx++] = nums[p2++];
        }
        System.arraycopy(temp, 0, nums, left, temp.length);
        return count;
    }
}
