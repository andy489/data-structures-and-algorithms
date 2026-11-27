// https://leetcode.com/problems/valid-elements-in-an-array/
class Solution {
    public int[] validElements(int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i - 1]);
        }
        suffixMax[n - 1] = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], nums[i + 1]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > prefixMax[i] || nums[i] > suffixMax[i]) {
                count++;
            }
        }
        int[] result = new int[count];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > prefixMax[i] || nums[i] > suffixMax[i]) {
                result[idx++] = nums[i];
            }
        }
        return result;
    }
}
