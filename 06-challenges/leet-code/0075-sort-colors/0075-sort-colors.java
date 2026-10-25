// https://leetcode.com/problems/sort-colors/

// Solution 1: Counting Sort — O(n) time, O(1) space (two passes)
class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];

        for (int num : nums) {
            count[num]++;
        }

        int k = 0;
        for (int color = 0; color < 3; color++) {
            for (int j = 0; j < count[color]; j++) {
                nums[k++] = color;
            }
        }
    }
}

// Solution 2: Dutch National Flag — O(n) time, O(1) space (one pass)
class Solution2 {
    public void sortColors(int[] nums) {
        int lo = 0, mid = 0, hi = nums.length - 1;

        while (mid <= hi) {
            if (nums[mid] == 0) {
                int tmp = nums[lo];
                nums[lo++] = nums[mid];
                nums[mid++] = tmp;
            } else if (nums[mid] == 1) {
                ++mid;
            } else {
                int tmp = nums[hi];
                nums[hi--] = nums[mid];
                nums[mid] = tmp;
            }
        }
    }
}
