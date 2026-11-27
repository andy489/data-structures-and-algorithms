// https://leetcode.com/problems/minimum-number-game/
class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i += 2) {
            result[i] = nums[i + 1];
            result[i + 1] = nums[i];
        }
        return result;
    }
}
