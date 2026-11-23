// https://leetcode.com/problems/shuffle-an-array/

// Solution: Fisher-Yates Shuffle — O(n) time, O(n) space
class Solution {
    private final int[] original;
    private final int[] nums;
    private final Random rand = new Random();

    public Solution(int[] nums) {
        this.original = nums.clone();
        this.nums = nums;
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, original.length);
        return nums;
    }

    public int[] shuffle() {
        for (int i = nums.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}
