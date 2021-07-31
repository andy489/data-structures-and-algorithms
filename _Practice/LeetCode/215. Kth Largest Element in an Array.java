// github.com/andy489
// https://leetcode.com/problems/kth-largest-element-in-an-array/
// O(n) in expectation

class Solution {
    private static Random rand = new Random();

    private static int partition(int[] nums, int l, int r) {
        int pivot = l + rand.nextInt(r - l + 1);
        nums[r] += nums[pivot] - (nums[pivot] = nums[r]);
        int i = l, j = l;
        for (; j <= r - 1; ++j) {
            if (nums[j] >= nums[r]) {
                nums[i] += nums[j] - (nums[j] = nums[i]);
                i++;
            }
        }
        nums[i] += nums[j] - (nums[j] = nums[i]);
        return i;
    }
    
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int pos = partition(nums, l, r);
            if (pos == k - 1) {
                return nums[pos];
            }
            if (pos < k - 1) {
                l = pos + 1;
            } else {
                r = pos - 1;
            }
        }
        return Integer.MIN_VALUE;
    }
}
